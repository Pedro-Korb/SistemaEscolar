# Sistema Escolar com Injeção de Dependência

## Trabalho da Matéria de Programação Orientada a Objetos 2

Este projeto é um sistema escolar que utiliza injeção de dependência em sua estrutura.

```html
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema Escolar</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        h1, h2 { color: #2c3e50; }
        ul { list-style-type: square; }
        li { margin: 10px 0; }
    </style>
</head>
<body>
    <h1>Sistema Escolar com Injeção de Dependência</h1>
    <h2>Trabalho da Matéria de Programação Orientada a Objetos 2</h2>
    <p>Este projeto é um sistema escolar que utiliza injeção de dependência em sua estrutura.</p>
    <h3>Funcionalidades e Requisitos:</h3>
    <ul>
        <li>É necessário ter a informação de qual curso o aluno está cursando.</li>
        <li>O curso é estruturado em fases e cada fase tem um rol de disciplinas.</li>
        <li>A disciplina pode ser lecionada por 1 ou até 4 professores.</li>
        <li>Controle de alunos e frequências.</li>
        <li>Como existe a possibilidade de mais de um professor por disciplina, é necessário saber qual professor fez o registro de frequência ou avaliação.</li>
        <li>É importante saber quais disciplinas já foram ofertadas.</li>
        <li>Um aluno pode se matricular em disciplinas de fases diferentes, não é necessário verificar pré-requisitos.</li>
        <li>Saber a situação do aluno em uma determinada disciplina (aprovado, reprovado, reprovado por falta).</li>
        <li>Elaborar um Diagrama de Classe, especificando os tipos de relações e multiplicidades entre os objetos.</li>
        <li>Utilizar Injeção de Dependência para realizar a persistência nos seguintes tipos: MySQL, JSON e XML.</li>
        <li>Criar um <code>main</code> onde o usuário possa escolher qual tipo de persistência utilizar.</li>
        <li>No mesmo <code>main</code>, criar uma sequência de passos para testar a persistência completa do sistema CRUD.</li>
        <li>Usar o projeto no anexo como modelo para a implementação.</li>
    </ul>
</body>
</html>
```

