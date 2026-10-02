package locadora;

import java.time.LocalDate;
import java.util.Date;

public class Locacao {

    private int id;
    private int idCliente;
    private int idFilme;
    private LocalDate dataLocacao;
    private int quantidade;
    private LocalDate dataDevolucao;
    private double valorTotal;

    public Locacao() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

   public LocalDate getDataLocacao() {
    return dataLocacao;
}

public void setDataLocacao(LocalDate dataLocacao) {
    this.dataLocacao = dataLocacao;
}
   
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
        
    }
    public LocalDate getDataDevolucao() {
    return dataDevolucao;
}

public void setDataDevolucao(LocalDate dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
}

public double getValorTotal() {
    return valorTotal;
}

public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
}
}