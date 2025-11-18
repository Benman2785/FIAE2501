<?php
session_start();
ob_start();

// CSRF-Token erzeugen (nur GET)
if ($_SERVER['REQUEST_METHOD'] === 'GET' && empty($_SESSION['csrf_token'])) {
    $_SESSION['csrf_token'] = bin2hex(random_bytes(32));
}

// CSRF-Token prüfen bei POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (
        !isset($_POST['csrf_token'], $_SESSION['csrf_token']) ||
        !hash_equals($_SESSION['csrf_token'], $_POST['csrf_token'])
    ) {
        die("denied CSRF-Token");
    }
}

// Datei-Upload-Logik vorbereiten
$uploadSuccess = false;
$uploadMessages = [];

if (isset($_POST["submit"])) {
    $target_dir = "/var/www/uploads/";

    // Skip empty uploads
    if (empty($_FILES['filesToUpload']['tmp_name'][0])) {
        header('Location: https://hoffmeister.li/uploads/');
        exit;
    }

    foreach ($_FILES["filesToUpload"]["tmp_name"] as $key => $tmp_name) {
        $uploadOk = 1;

        $fileName = preg_replace("/[^a-zA-Z0-9\._-]/", "_", basename($_FILES["filesToUpload"]["name"][$key]));
        $fileExtension = strtolower(pathinfo($fileName, PATHINFO_EXTENSION));
        $allowedTypes = ['jpg', 'jpeg', 'png', 'gif', 'webp', 'webm', 'mp4', 'm4v', 'mp3', 'm4a', 'ogg', 'aac', 'txt', 'pdf', 'doc', 'docx', 'ppt', 'zip', 'rar', '7z'];

        $finfo = finfo_open(FILEINFO_MIME_TYPE);
        $mimeType = finfo_file($finfo, $tmp_name);
        finfo_close($finfo);

        $allowedMimes = [
            'image/jpeg', 'image/png', 'image/gif', 'image/webp',
            'video/webm', 'video/mp4', 'video/x-m4v',
            'audio/mpeg', 'audio/mp4', 'audio/ogg', 'audio/aac',
            'text/plain', 'application/pdf', 'application/msword',
            'application/vnd.openxmlformats-officedocument.wordprocessingml.document',
            'application/vnd.ms-powerpoint',
            'application/zip', 'application/x-rar-compressed', 'application/x-7z-compressed',
        ];

        if (!in_array($mimeType, $allowedMimes)) {
            $uploadMessages[] = "unallowed MIME-type ($mimeType) for $fileName";
            $uploadOk = 0;
        }

        $target_file = $target_dir . $fileName;

        // Automatisch umbenennen, wenn Datei existiert
        if (file_exists($target_file)) {
            $baseName = pathinfo($fileName, PATHINFO_FILENAME);
            $counter = 1;
            do {
                $newName = $baseName . '_' . $counter . '.' . $fileExtension;
                $target_file = $target_dir . $newName;
                $counter++;
            } while (file_exists($target_file));
            $fileName = $newName;
        }

        if (!in_array($fileExtension, $allowedTypes)) {
            $uploadMessages[] = "unallowed filetype: $fileName";
            $uploadOk = 0;
        }

        if (preg_match('/\.php[3457]?$/i', $fileName)) {
            $uploadMessages[] = "PHP-files are not allowed.";
            $uploadOk = 0;
        }

        if ($_FILES["filesToUpload"]["size"][$key] > 250 * 1024 * 1024) {
            $uploadMessages[] = "file $fileName is to large. (max 250MB)";
            $uploadOk = 0;
        }

        if ($uploadOk == 1) {
            if (move_uploaded_file($tmp_name, $target_file)) {
                $uploadMessages[] = "file $fileName uploaded successfully.";
                $uploadSuccess = true;
            } else {
                $uploadMessages[] = "error while uploading $fileName.";
            }
        }
    }

    if ($uploadSuccess) {
        unset($_SESSION['csrf_token']);
        header('Location: https://hoffmeister.li/uploads/');
        exit;
    }
}
?>
<!doctype html>
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">
    <meta name="author" content="Benjamin Hoffmeister">
    <meta name="creator" content="Screendesign Whykiki">
    <meta name="publisher" content="hoffmeister.li">

    <link rel="shortcut icon" href="https://hoffmeister.li/favicon.ico">
    <link rel="stylesheet" type="text/css" href="https://hoffmeister.li/benmanshafen.css">
    <link href='https://hoffmeister.li/font.css' rel='stylesheet' type='text/css'>

    <title>Hidden File Upload</title>
<style>
#drop-zone {
    border: 2px dashed #aaa;
    border-radius: 8px;
    padding: 20px;
    text-align: center;
    color: white;
    cursor: pointer;
    margin-bottom: 1em;
}
#drop-zone.hover {
    background-color: rgba(255, 255, 255, 0.1);
}
#file-list {
    color: white;
    margin-top: 10px;
    font-size: 0.9em;
}
</style>
</head>
<script>
document.addEventListener("DOMContentLoaded", function () {
    const dropZone = document.getElementById("drop-zone");
    const fileInput = document.getElementById("file-input");
    const fileList = document.getElementById("file-list");
    const totalSizeDisplay = document.createElement("div");
    fileList.parentElement.appendChild(totalSizeDisplay);
    totalSizeDisplay.style.color = "white";
    totalSizeDisplay.style.marginTop = "1em";

    dropZone.addEventListener("click", () => fileInput.click());

    dropZone.addEventListener("dragover", (e) => {
        e.preventDefault();
        dropZone.classList.add("hover");
    });

    dropZone.addEventListener("dragleave", () => {
        dropZone.classList.remove("hover");
    });

    dropZone.addEventListener("drop", (e) => {
        e.preventDefault();
        dropZone.classList.remove("hover");

        if (e.dataTransfer.files.length) {
            fileInput.files = e.dataTransfer.files;
            updateFileList();
        }
    });

    fileInput.addEventListener("change", updateFileList);

    function updateFileList() {
        fileList.innerHTML = "";
        let totalSize = 0;

        for (let i = 0; i < fileInput.files.length; i++) {
            const file = fileInput.files[i];
            totalSize += file.size;

            const item = document.createElement("div");
            item.textContent = `${file.name} (${(file.size / 1024 / 1024).toFixed(2)} MB)`;
            fileList.appendChild(item);
        }

        totalSizeDisplay.textContent = `combined size: ${(totalSize / 1024 / 1024).toFixed(2)} MB`;

        if (totalSize > 250 * 1024 * 1024) {
            alert("total uploadsize over 250MB - its most-likely to fail");
        }
    }
});
</script>
<body>
<section id="content">
    <header>
        <h2>Select file(s) to upload (max 250MB & 15min)</h2><hr>
    </header><br>

    <form action="upload.php" method="post" enctype="multipart/form-data">
        <input type="hidden" name="csrf_token" value="<?php echo htmlspecialchars($_SESSION['csrf_token'], ENT_QUOTES, 'UTF-8'); ?>">
        <div id="drop-zone"><br>DRAG & DROP files OR klick here to choose them via prompt<br><br>
            <input type="file" name="filesToUpload[]" id="file-input" multiple
                   accept=".jpg,.jpeg,.png,.gif,.webp,.webm,.mp4,.m4v,.mp3,.m4a,.ogg,.aac,.txt,.pdf,.doc,.docx,.ppt,.zip,.rar,.7z"
                   style="display: none;">
        </div>
        <input type="submit" value="upload" name="submit">
        <div id="file-list"></div>

        <?php if (!empty($uploadMessages)): ?>
            <div class="error-message" style="color: white;">
                <?php foreach ($uploadMessages as $msg): ?>
                    <p><?php echo htmlspecialchars($msg, ENT_QUOTES, 'UTF-8'); ?></p>
                <?php endforeach; ?>
            </div>
        <?php endif; ?>
    </form><br>
</section>
</body>
</html>
<?php ob_end_flush(); ?>