package error;

public class TratamentoDeErro implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String mensagem = "Erro ao preencher formulário. Verifique os campos de entrada e tente novamente!";
        JanelaErro.exibirErro(mensagem);
        e.printStackTrace();
    }
}