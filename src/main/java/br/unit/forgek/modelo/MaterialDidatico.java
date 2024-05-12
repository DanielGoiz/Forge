package br.unit.forgek.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class MaterialDidatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank(message = "Adicione a URL do video")
    private String video;

    @NotBlank(message = "Adicione uma descrição do video")
    private String descricao;

    public long getID(){
        return ID;
    }
    public void setID(long ID){
        this.ID = ID;
    }
    public String getVideo(){
        return video;
    }
    public void SetVideo(String video){
        this.video = video;
    }

    public String getDescricao(){
        return descricao;
    }
    public void SetDescricao(String descricao){
        this.descricao = descricao;
    }



}
