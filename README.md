![](https://user-images.githubusercontent.com/20418546/63717895-acca6f00-c81f-11e9-8ca9-52d5a4b4eb79.jpg)

![](https://lh5.googleusercontent.com/S9_Vg-Hf4N6dqBP7MeTYJxP1M0QFWreYP1pCm7ub-L3s3GgCPhg8Y4WPeSm0pnxJthD0Sp3dH_HWaGVTFEJanP_2nbH9g-6nJjEaai_SBBOzMn991MxWs--HyMiNrhrvQ2WriWEP)

# eDoe
## Descrição
  Muitas pessoas tem interesse em fazer doações, mas as vezes não tem o tempo necessário para encontrar onde doar ou como doar. Como sabemos, vivemos em um país em que a desigualdade social ainda existe e por isso há várias pessoas necessitadas, às vezes grupos de pessoas com um problema em comum. 
  
  No eDoe.com usuários de toda a região envolvida podem cadastrar itens a serem doados. Usuários também podem cadastrar itens necessários e o sistema deve saber casar doações com necessidades para facilitar a doação. Uma vez fechada uma doação, o sistema ajuda a organizar o encontro de doador/receptor.
  
  [Descrição completa do projeto](https://docs.google.com/document/d/e/2PACX-1vST2TI5lDbtMlv8rhFYJkYnrfgqzyWDv6DDvvAajz3_KK4tAs_UnAbYdI6oeMQA6jEHo5HwUAatHmd8/pub)
  
## Diagrama
  [Diagrama ER](https://www.lucidchart.com/invitations/accept/e59ce12a-a45c-4c78-995e-0984821c3a90)
  
## Pré requisitos
  * Uma IDE de sua preferência
  * Postman
  * Java 8
  * Maven
  * MySQL

## Desenvolvimento

   * O Sistema Operacional usado foi o *Windows* e as tecnologias utilizadas foram a LP *Java*, *Spring Boot* e a API *Postman* para testar o serviço RESTful por meio do envio de requisições HTTP e da análise do seu retorno. 
   
   * Utilizamos o *Spring JPA* para integrarmos os objetos Java em um banco de dados *MySQL*, possibilitando a persistência dos mesmos. A IDE utilizada foi o *STS IDE*.
   
## Rodando o Projeto
Dentro da pasta do projeto rode os comandos abaixo via terminal.
```
mvnw clean install package
mvn spring-boot:run
```
