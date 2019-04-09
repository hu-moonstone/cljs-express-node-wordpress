FROM node:8

RUN useradd --user-group --create-home --shell /bin/false app
ENV HOME=/home/app

COPY package.json $HOME/nodeapp/
COPY package-lock.json $HOME/nodeapp/
COPY app-dev.js $HOME/nodeapp/
COPY develop $HOME/nodeapp/

RUN chown -R app:app $HOME/*

USER app
WORKDIR $HOME/nodeapp
RUN npm install

USER root
RUN chown -R app:app $HOME/*
USER app

WORKDIR $HOME/nodeapp
EXPOSE 3000

CMD ["npm", "start"]
