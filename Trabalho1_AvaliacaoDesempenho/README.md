<h1>Trabalho Prático 1 - Avaliação de desempenho.</h1>

<p><strong>Objetivo</strong></p>

<p>Desenvolver uma aplicação usando Sockets UDP para avaliação de desempenho, similar ao comando ping.</p>

<p><strong>Especificações:</strong></p>
<ol>
    <li>Utilizar o protocolo UDP.</li>
    <li>A aplicação deve determinar o RTT médio e a taxa de perda de pacotes entre dois hospedeiros. Não considere os pacotes perdidos no cálculo do RTT médio.</li>
    <li>As métricas devem ser calculadas a partir de 10 tentativas de envio de mensagens entre um programa cliente e o servidor. Mantenha um intervalo de 1s entre o envio das mensagens, para não mandar uma rajada de mensagens ao servidor.</li>
    <li>Considere um timeout de 250ms para determinar que uma mensagem foi perdida.</li>
    <li><strong>Implementar apenas o cliente</strong>. O servidor já está disponível no host 18.224.220.128 na porta 6000. O servidor recebe uma mensagem com uma string e retorna a própria string para o cliente, apenas para permitir o cálculo do RTT.</li>
    <li>O RTT pode ser calculado como o tempo gasto desde o envio da string até o recebimento da resposta.</li>
    <li>Pode-se usar qualquer linguagem de programação.</li>
</ol>