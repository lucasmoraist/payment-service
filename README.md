# payment-service

Preciso de ajuda para solução de um seguinte cenário 

eu tenho uma aplicação que utiliza redis para gravar algumas informações que são perdidas após fazer a chamada para um cliente, após esse cliente retornar a chamada no callback, eu pega o meu valor do redis e processo ele de volta com a resposta retornada no callback

mas existe o cenário em que, se o cliente não retornar dentro de 35 segundos nós devemos processar um fallback com uma resposta default

hoje eu salvo as informações com um ttl no redis de 35 segundos e minha aplicação escuta eventos gerado pelo redis, mas hoje houve um cenário em que minha aplicação só escutou o evento 58 segundos depois, ou seja, o redis demorou para gerar o evento, oque eu posso fazer para solucionar isso?