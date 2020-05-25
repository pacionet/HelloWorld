
package com.nttdata.be.apigw.listaconsulenze;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "motoreConsulenza",
    "dataAcquisizione",
    "id",
    "dataScadenza",
    "stato",
    "ndgRapportoIntestazione",
    "ndgCliente",
    "frazionario",
    "terminale",
    "userID",
    "cob"
})
public class ListaConsulenzeBeResponse {

    @JsonProperty("version")
    private String version;
    @JsonProperty("motoreConsulenza")
    private String motoreConsulenza;
    @JsonProperty("dataAcquisizione")
    private String dataAcquisizione;
    @JsonProperty("id")
    private String id;
    @JsonProperty("dataScadenza")
    private String dataScadenza;
    @JsonProperty("stato")
    private String stato;
    @JsonProperty("ndgRapportoIntestazione")
    private String ndgRapportoIntestazione;
    @JsonProperty("ndgCliente")
    private String ndgCliente;
    @JsonProperty("frazionario")
    private String frazionario;
    @JsonProperty("terminale")
    private String terminale;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("cob")
    private String cob;

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("motoreConsulenza")
    public String getMotoreConsulenza() {
        return motoreConsulenza;
    }

    @JsonProperty("motoreConsulenza")
    public void setMotoreConsulenza(String motoreConsulenza) {
        this.motoreConsulenza = motoreConsulenza;
    }

    @JsonProperty("dataAcquisizione")
    public String getDataAcquisizione() {
        return dataAcquisizione;
    }

    @JsonProperty("dataAcquisizione")
    public void setDataAcquisizione(String dataAcquisizione) {
        this.dataAcquisizione = dataAcquisizione;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("dataScadenza")
    public String getDataScadenza() {
        return dataScadenza;
    }

    @JsonProperty("dataScadenza")
    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @JsonProperty("stato")
    public String getStato() {
        return stato;
    }

    @JsonProperty("stato")
    public void setStato(String stato) {
        this.stato = stato;
    }

    @JsonProperty("ndgRapportoIntestazione")
    public String getNdgRapportoIntestazione() {
        return ndgRapportoIntestazione;
    }

    @JsonProperty("ndgRapportoIntestazione")
    public void setNdgRapportoIntestazione(String ndgRapportoIntestazione) {
        this.ndgRapportoIntestazione = ndgRapportoIntestazione;
    }

    @JsonProperty("ndgCliente")
    public String getNdgCliente() {
        return ndgCliente;
    }

    @JsonProperty("ndgCliente")
    public void setNdgCliente(String ndgCliente) {
        this.ndgCliente = ndgCliente;
    }

    @JsonProperty("frazionario")
    public String getFrazionario() {
        return frazionario;
    }

    @JsonProperty("frazionario")
    public void setFrazionario(String frazionario) {
        this.frazionario = frazionario;
    }

    @JsonProperty("terminale")
    public String getTerminale() {
        return terminale;
    }

    @JsonProperty("terminale")
    public void setTerminale(String terminale) {
        this.terminale = terminale;
    }

    @JsonProperty("userID")
    public String getUserID() {
        return userID;
    }

    @JsonProperty("userID")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @JsonProperty("cob")
    public String getCob() {
        return cob;
    }

    @JsonProperty("cob")
    public void setCob(String cob) {
        this.cob = cob;
    }

}
