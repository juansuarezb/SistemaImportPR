/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MóduloVentaFacturación;

import java.util.ArrayList;

/**
 *
 * @author Rose Molina
 */
public class Usuario {
    
    private String mNombre;
    private String mPass;
    private String mCorreoElectronico;
    private ArrayList<String> mListaRoles = new ArrayList();
    private boolean mHizoEncuestaExperiencia;
    private boolean mHizoEncuestaPersonal;
    private ArrayList<Encuesta> mListaEncuestas = new ArrayList();
   

    /**
     * @return the mNombre
     */
    public String getNombre() {
        return mNombre;
    }

    /**
     * @param mNombre the mNombre to set
     */
    public void setNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    /**
     * @return the mPass
     */
    public String getPass() {
        return mPass;
    }

    /**
     * @param mPass the mPass to set
     */
    public void setPass(String mPass) {
        this.mPass = mPass;
    }

    /**
     * @return the mCorreoElectronico
     */
    public String getCorreoElectronico() {
        return mCorreoElectronico;
    }

    /**
     * @param mCorreoElectronico the mCorreoElectronico to set
     */
    public void setCorreoElectronico(String mCorreoElectronico) {
        this.mCorreoElectronico = mCorreoElectronico;
    }

    /**
     * @return the mListaRoles
     */
    public ArrayList<String> getListaRoles() {
        return mListaRoles;
    }

    /**
     * @param pListaRoles the mListaRoles to set
     */
    public void setListaRoles(ArrayList<String> pListaRoles) {
        this.mListaRoles = pListaRoles;
    }

    /**
     * @return the mHizoEncuesta
     */
    public boolean getHizoEncuestaExperiencia() {
        return mHizoEncuestaExperiencia;
    }

    /**
     * @param mHizoEncuestaExperiencia the mHizoEncuestaExperiencia to set
     */
    public void setHizoEncuestaExperiencia(boolean mHizoEncuestaExperiencia) {
        this.mHizoEncuestaExperiencia = mHizoEncuestaExperiencia;
    }
   
     /**
     * @return the mHizoEncuesta
     */
    public boolean getHizoEncuestaPersonal() {
        return mHizoEncuestaPersonal;
    }

    /**
     * @param mHizoEncuestaPersonal the mHizoEncuesta to set
     */
    public void setHizoEncuestaPersonal(boolean mHizoEncuestaPersonal) {
        this.mHizoEncuestaPersonal = mHizoEncuestaPersonal;
    }

    /**
     * @return the mListaEncuestas
     */
    public ArrayList<Encuesta> getListaEncuestas() {
        return mListaEncuestas;
    }

    /**
     * @param pListaEncuestas the pListaEncuestas to set
     */
    public void setListaEncuestas(ArrayList<Encuesta> pListaEncuestas) {
        this.mListaEncuestas = pListaEncuestas;
    }
    
    public void setAgregarEncuesta (Encuesta pEncuesta){
        mListaEncuestas.add(pEncuesta);
    }

}
