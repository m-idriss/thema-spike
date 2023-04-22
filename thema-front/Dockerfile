### STAGE 1: Build ###
FROM arm32v7/node:14.18.1-alpine AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM arm32v7/nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/thema-front /usr/share/nginx/html
EXPOSE 80
