public final class LivroDigital extends Livro {

    private String formatoArquivo;
    private double tamanhoArquivo;

    public LivroDigital(){
        //super(); implicitamente é invocado o método construtor default
    }

    public LivroDigital(String titulo, 
                        String autor, 
                        int anoPublicacao, 
                        int numeroPaginas, 
                        String formatoArquivo,
                        double tamanhoArquivo) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
        
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override //opcional
    public String toString() {
        String dadosLivro = super.toString();
        return dadosLivro 
                    + ", Formato: " + this.getFormatoArquivo() //acesso via Get
                    + ", Tamanho: " + tamanhoArquivo; //acesso direto do atributo
    }

    @Override
    public String getTipoLivro() {
        return "Livro Digital";
    }
}
