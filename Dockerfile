FROM openjdk:8

ARG ARG_URL_MINSAL_COMUNAS_POR_REGIONES=https://midastest.minsal.cl/farmacias/maps/index.php/utilidades/maps_obtener_comunas_por_regiones 
ENV URL_MINSAL_COMUNAS_POR_REGIONES=$ARG_URL_MINSAL_COMUNAS_POR_REGIONES

ARG ARG_URL_MINSAL_LOCALES_POR_REGIONES=https://farmanet.minsal.cl/maps/index.php/ws/getLocalesRegion
ENV URL_MINSAL_LOCALES_POR_REGIONES=$ARG_URL_MINSAL_LOCALES_POR_REGIONES

ARG ARG_URL_MINSAL_ID_REGION=7
ENV URL_MINSAL_ID_REGION=$ARG_URL_MINSAL_ID_REGION

ADD target/farmaciaTurno-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]