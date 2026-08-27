package engtelecom.std;

import module java.base;

public record AtenderClientes(Socket clientSocket) implements Runnable {
    @Override
    public void run() {
        try (
            var dis = new DataInputStream(clientSocket.getInputStream());
            var dos = new DataOutputStream(clientSocket.getOutputStream())) {

            String nomeArquivo = dis.readUTF();
            System.out.println("Arquivo solicitado: " + nomeArquivo);
            
            if (Files.exists(Path.of(nomeArquivo))) {
                // Se o arquivo existe, envie seu tamanho e conteúdo
                long tamanho = Files.size(Path.of(nomeArquivo));

                dos.writeLong(tamanho);
                dos.flush();

                long bytesEnviados = Files.copy(Path.of(nomeArquivo), dos);
                dos.flush();

                System.out.printf("Enviado: %s (%d bytes)%n", nomeArquivo, bytesEnviados);
            } else {
                // Se o arquivo não existe, envie -1 para indicar erro
                dos.writeLong(-1);
                dos.flush();

                
                System.out.println("Arquivo não encontrado: " + nomeArquivo);
            }
        }
    }
}
