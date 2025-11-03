# =================================================================
# STAGE 1: FASE DE CONSTRUÇÃO (BUILD)
# Esta fase instala dependências e compila o código TypeScript para JavaScript.
# =================================================================
FROM node:20-alpine AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de definição de dependência (package.json e package-lock.json)
# Isso é feito primeiro para aproveitar o cache do Docker, pois esses arquivos mudam menos.
COPY package*.json ./

# Instala todas as dependências (incluindo as de desenvolvimento, necessárias para o TS)
RUN npm install

# Copia todo o código-fonte
COPY . .

# Compila o código TypeScript para JavaScript
# Assumindo que você tem um script 'npm run build' que gera os arquivos em /dist
RUN npm run build


# =================================================================
# STAGE 2: FASE DE PRODUÇÃO (FINAL)
# Esta fase usa uma imagem base mínima para rodar a aplicação compilada,
# o que resulta em uma imagem de produção menor e mais segura.
# =================================================================
FROM node:20-alpine

# Define o diretório de trabalho final
WORKDIR /app

# Copia SOMENTE os arquivos compilados (da fase 'builder') e as dependências de produção
# Copia o código JS compilado
COPY --from=builder /app/dist ./dist
# Copia o package.json de novo (só para que o 'npm start' funcione)
COPY package.json ./

# Instala apenas as dependências necessárias para RODAR (dependencies, sem devDependencies)
RUN npm install --omit=dev

# Expõe a porta que o servidor Express está escutando (porta 3000 em server.ts)
EXPOSE 3000

# Comando para iniciar a aplicação compilada
# Assumindo que seu package.json tenha um script "start": "node dist/server.js"
CMD [ "npm", "start" ]