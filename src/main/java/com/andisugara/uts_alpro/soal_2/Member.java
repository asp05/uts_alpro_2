/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andisugara.uts_alpro.soal_2;

/**
 *
 * @author andi
 */
public class Member {
    private String kodeMember;
    private String nama;
    private String nomorTelepon;

    public Member(String kodeMember, String nama, String nomorTelepon) {
        this.kodeMember = kodeMember;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    
    
    public String getKodeMember() {
        return kodeMember;
    }

    public void setKodeMember(String kodeMember) {
        this.kodeMember = kodeMember;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}
