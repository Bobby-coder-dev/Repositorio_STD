package engtelecom.std;

import module java.base;

public record AtenderClientes(Socket clientSocket) implements Runnable {
    @Override
    public void run() {
        try {
         var enderecoCliente = clientSocket.getInetAddress().getHostAddress();
            var portaCliente = clientSocket.getPort();

            System.out.printf("Cliente conectado: %s:%d%n", enderecoCliente, portaCliente);

            // Estabelecimentos de fluxos de entrada de saida
            var reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8)
            );
            var writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8)
            );

            // Protocolo de comunicação
            String mensagem;
            while(true) {
                mensagem = reader.readLine();

                if(mensagem == null) break;
                
                System.out.printf("[%s:%d] -> %s\n", enderecoCliente, portaCliente, mensagem);

                writer.write(mensagem.toUpperCase());
                writer.newLine();
                writer.flush();

                if(mensagem.equalsIgnoreCase("SAIR")) break;
            }

            IO.println(".: Sistema encerrado! :.");

            reader.close();
            writer.close();
        } catch (Exception e) {

            System.err.println("Erro: " + e);

        }
    }
}
