# Procurando por imagens no Docker Hub (veja se a coluna OFFICIAL esta com OK)

docker search gradle

# Baixando uma imagem do Docker Hub com uma versao especifica (tag)

docker pull eclipse-temurin:25-jdk

# Baixando uma imagem do Docker Hub (nesse caso, tag latest e a padrao)

docker pull ubuntu

# Listando as imagens armazenadas (baixadas ou geradas) em seu computador

docker images

# Executando um conteiner, modo interativo, a partir da imagem 'ubuntu' oficial

docker run -it --rm --name primeiro ubuntu

# Execute o comando abaixo para ver qual a versao do Ubuntu

cat /etc/os-release

# Execute exit para sair da shell do conteiner

exit

# Executando compilador javac que esta na imagem eclipse-temurin:21-jdk para compilar

# um arquivo chamado Teste.java que esta no diretorio atual do host

docker run --rm -v `pwd`:/app -w /app eclipse-temurin:21-jdk javac Teste.java

# Para listar os conteineres que estao em execucao

docker ps

# Para listar os conteineres que estao em execucao e os inativos

docker ps -a

# Para verificar estatisticas (uso de CPU, memoria, I/O) dos conteineres ativos

docker stats

# Para finalizar a execucao de um conteiner

docker stop <container ID ou nome do conteiner>

# Para iniciar um conteiner que foi parado (-ai para modo interativo)

docker start -ai <container ID ou nome do conteiner>

# Para remover um conteiner

docker rm <container ID ou nome do conteiner>

# Para remover todos os conteineres inativos de uma so vez

docker container prune