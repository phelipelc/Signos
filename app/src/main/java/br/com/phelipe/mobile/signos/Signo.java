package br.com.phelipe.mobile.signos;

/**
 * Created by Phelipe Lopes on 08/10/2017.
 */
import java.io.Serializable;

public class Signo implements Serializable{
    private int diainicio;
    private int diafim;
    private int mesinicio;
    private int mesfim;
    private String nome;
    private String imagem;

    public Signo(){

    }
    public Signo(int diainicio, int mesinicio, int diafim,int mesfim,String nome,String imagem){
         this.diainicio = diainicio;
         this.diafim = diafim;
         this.mesinicio = mesinicio;
         this.mesfim = mesfim;
         this.nome = nome;
         this.imagem = imagem;
    }
    public int getDiainicio(){ return diainicio; }
    public int getDiaFim(){ return diafim; }
    public int getMesinicio(){ return mesinicio; }
    public int getMesfim(){ return mesfim; }
    public String getNome(){ return nome; }
    public String getImagem(){ return imagem; }

}
