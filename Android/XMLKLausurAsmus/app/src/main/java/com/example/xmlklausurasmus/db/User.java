package com.example.xmlklausurasmus.db;

import java.util.Calendar;

/**
 * @author Ben
 *
 * erstellt am 04.11.2025
 *
 * Die Klasse User bildet die Tablle User in unserem Androidprojekt ab.
 *
 */
public class User {

    private Integer id;
    private String username, pw;
    private Calendar erstelltAm;
    private int aktiv;

    /**
     * @param username
     * @param pw
     * @param erstelltAm
     * @param aktiv
     */

    public User(String username, String pw, Calendar erstelltAm, int aktiv) {
        this.username = username;
        this.pw = pw;
        this.erstelltAm = erstelltAm;
        this.aktiv = aktiv;
    }

    public Integer get_id() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public Calendar getCalendar() {
        return erstelltAm;
    }
    public void setCalendar(Calendar erstelltAm) {
        this.erstelltAm = erstelltAm;
    }
    public int getAktiv() {
        return aktiv;
    }
    public void setAktiv(int aktiv) {
        this.aktiv = aktiv;
    }



}
