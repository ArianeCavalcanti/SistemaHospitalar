/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author senacead
 */
public class Convenio {

    private int idConvenio;
    private String nomeConvenio;
    private String tempoCarencia;
    private String cnpj;


    public Convenio() {
    }
    
    public Convenio(int idConvenio, String nomeConvenio, String tempoCarencia, String cnpj) {
        this.idConvenio = idConvenio;
        this.nomeConvenio = nomeConvenio;
        this.tempoCarencia = tempoCarencia;
        this.cnpj = cnpj;
    }

    public int getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(int idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getTempoCarencia() {
        return tempoCarencia;
    }

    public void setTempoCarencia(String tempoCarencia) {
        this.tempoCarencia = tempoCarencia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
