package ifpr.pgua.eic.avaliacao01.controllers.viewmodels;

import ifpr.pgua.eic.avaliacao01.model.results.Result;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TelaLivrosViewModel {

    private StringProperty tituloProperty = new SimpleStringProperty();
    private StringProperty editoraProperty = new SimpleStringProperty();
    private StringProperty paginasProperty = new SimpleStringProperty();
    private StringProperty anoPublicacaoProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();

    private ObservableList<LivroRow> livros = FXCollections.observableArrayList();
    private String editora;
    private String titulo;
    private Integer paginas;
    private Integer paginas2;
    private Integer anoPublicacao;

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getPaginas2() {
        return paginas2;
    }

    public void setPaginas2(Integer paginas2) {
        this.paginas2 = paginas2;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public TelaLivrosViewModel() {
        editora = editoraProperty.getValue();
        titulo = tituloProperty.getValue();
        paginas2 = paginas;
    }

    public StringProperty tituloProperty() {
        return tituloProperty;
    }

    public StringProperty editoraProperty() {
        return editoraProperty;
    }

    public StringProperty anoPublicacaoProperty() {
        return anoPublicacaoProperty;
    }

    public StringProperty paginasProperty() {
        return paginasProperty;
    }


    public ObjectProperty<Result> alertProperty() {
        return alertProperty;
    }

    public void updateList() {
        livros.clear();
        
        alertProperty.setValue(Result.fail("BUSCAR DO BANCO DE DADOS"));

    }

    public void cadastrar() {

        String sPaginas = paginasProperty.getValue();
        String sAnoPublicacao = anoPublicacaoProperty.getValue();

        paginas = Integer.valueOf(sPaginas);
        anoPublicacao = Integer.valueOf(sAnoPublicacao);

        

        limpar();

        alertProperty.setValue(Result.fail("INSERIR NO BANCO DE DADOS!!!"));
    }

    public void limpar() {
        tituloProperty.setValue("");
        editoraProperty.setValue("");
        anoPublicacaoProperty.setValue("");
        paginasProperty.setValue("");
    }

    public ObservableList<LivroRow> getLivros() {
        return livros;
    }
    
}
