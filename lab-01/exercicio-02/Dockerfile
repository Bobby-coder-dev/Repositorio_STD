FROM ubuntu:26.04

WORKDIR /app 

RUN apt-get update && \
    apt-get -y install netcat-openbsd figlet toilet fastfetch nyancat && \
    rm -rf /var/lib/apt/lists/*

COPY mensagem.txt /app/

CMD [ "/bin/sh", "-c", "cat mensagem.txt | toilet -F border --gay -f smblock" ]