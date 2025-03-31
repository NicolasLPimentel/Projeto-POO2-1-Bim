public class App {
    public static void main(String[] args) {
        Util.iniciarInput();
        Boolean[] quartos = new Boolean[100];
        String[][] hospedes = new String[100][2];
        int id = 0;
        byte opcao;

        // Inicializa os quartos e hóspedes
        for (int i = 0; i < 100; i++) {
            quartos[i] = false;
            hospedes[i][0] = "nenhum";
            hospedes[i][1] = "nenhum";
        }

        Util.print("Bem-vindo\n");

        while (true) {
            Util.print("\nSelecione uma opção:\n"
                    + "\n1 - Reservar quarto"
                    + "\n2 - Cancelar reserva"
                    + "\n3 - Listar reservas"
                    + "\n4 - Consultar hóspede"
                    + "\n5 - Editar hóspede"
                    + "\n0 - Sair\n");

            opcao = (byte) Util.lerInt("Digite a opção: ");

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    reservarQuarto(quartos, hospedes, id);
                    break;
                case 2:
                    cancelarReserva(quartos, hospedes);
                    break;
                case 3:
                    listarReservas(quartos, hospedes);
                    break;
                case 4:
                    consultarHospede(hospedes);
                    break;
                case 5:
                    editarHospede(quartos, hospedes);
                    break;
                default:
                    Util.print("Opção inválida!");
            }
        }
        Util.fecharInput();
    }

    private static void reservarQuarto(Boolean[] quartos, String[][] hospedes, int id) {
        if (ocupacaoTotal(quartos)) {
            Util.print("Todos os quartos estão ocupados.");
            return;
        }
        String nome = Util.lerString("Insira seu nome: ");
        int numQuarto = escolherQuarto(quartos);
        id++;
        hospedes[numQuarto][0] = Integer.toString(id);
        hospedes[numQuarto][1] = nome;
        quartos[numQuarto] = true;
        Util.print("Quarto reservado com sucesso!");
    }

    private static boolean ocupacaoTotal(Boolean[] quartos) {
        for (boolean ocupado : quartos) {
            if (!ocupado) return false;
        }
        return true;
    }

    private static int escolherQuarto(Boolean[] quartos) {
        int numQuarto;
        while (true) {
            numQuarto = Util.lerInt("Insira o número do quarto (1-100): ") - 1;
            if (numQuarto >= 0 && numQuarto < 100 && !quartos[numQuarto]) {
                return numQuarto;
            }
            Util.print("Quarto inválido ou ocupado. Escolha outro.");
        }
    }

    private static void cancelarReserva(Boolean[] quartos, String[][] hospedes) {
        int id = Util.lerInt("Insira o número da RESERVA: ");
        String idString = Integer.toString(id);
        for (int i = 0; i < 100; i++) {
            if (hospedes[i][0].equals(idString)) {
                hospedes[i][0] = "nenhum";
                hospedes[i][1] = "nenhum";
                quartos[i] = false;
                Util.print("Reserva removida com sucesso!");
                return;
            }
        }
        Util.print("Número da reserva não encontrado.");
    }

    private static void listarReservas(Boolean[] quartos, String[][] hospedes) {
        Util.print("\nQuartos:\n");
        for (int i = 0; i < 100; i++) {
            String status = quartos[i] ? "Reservado por " + hospedes[i][1] + " (Reserva: " + hospedes[i][0] + ")" : "Disponível";
            Util.print("Quarto " + (i + 1) + ": " + status);
        }
    }

    private static void consultarHospede(String[][] hospedes) {
        int numQuarto = Util.lerInt("Insira o número do quarto (1-100): ") - 1;
        if (numQuarto >= 0 && numQuarto < 100) {
            Util.print("Hóspede: " + hospedes[numQuarto][1] + " | Reserva: " + hospedes[numQuarto][0]);
        } else {
            Util.print("Número de quarto inválido.");
        }
    }

    private static void editarHospede(Boolean[] quartos, String[][] hospedes) {
        int numQuarto = Util.lerInt("Insira o número do quarto (1-100): ") - 1;
        if (numQuarto < 0 || numQuarto >= 100 || !quartos[numQuarto]) {
            Util.print("Quarto inválido ou sem reserva.");
            return;
        }
        String novoNome = Util.lerString("Insira o novo nome: ");
        hospedes[numQuarto][1] = novoNome;
        Util.print("Hóspede atualizado com sucesso!");
    }
}
