class Consulta {
    private Paciente paciente;
    private String data;
    private String horario;
    private String especialidade;
    private String medico;

    public Consulta(Paciente paciente, String data, String horario, String especialidade, String medico) {
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
        this.especialidade = especialidade;
        this.medico = medico;
    }

    public String getCpfPaciente() {
        return paciente.getCpf();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void exibirDetalhes() {
        System.out.println("Consulta com " + medico + " | Especialidade: " + especialidade +
                " | Data: " + data + " | Horário: " + horario);
        paciente.exibirInformacoes();
    }
}