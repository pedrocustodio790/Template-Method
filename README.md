# Template-Method
salvar  
nesse caso eu esotu usando axios no emu front para fazer a funçao do fetch  e  esse e meu codigo <!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SENAI - Turmas</title>
    <script src="../JS/ScriptTurma.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="../CSS/style.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <div class="logo">
                <h1>SENAI</h1>
                <p>Sistema de Gestão - São Carlos, SP</p>
            </div>
            <nav class="nav-top">
                <button class="nav-button active">Turmas</button>
                <button class="nav-button">Alunos</button>
                <button class="nav-button">Atividades</button>
                <button onclick="window.location.href='criar_turma.html'">Criar Turma</button>
                <button onclick="window.location.href='alunos.html'">Ver Alunos</button>
                <button onclick="window.location.href='criar_atividades.html'">Criar Atividades</button>
            </nav>
            <div class="nav-bottom">
                <button class="nav-button">Sair</button>
            </div>
        </aside>
        <main class="main-content">
            <h2>Turmas</h2>
            <button class="add-button">+ turma</button>
            <table class="header-table">
                <tr>
                    <th>Sigla</th>
                    <th>Nome</th>
                    <th>Termo</th>
                    <th>Ações</th>
                </tr>
            </table>
            <table class="data-table">
                <tbody>
                    <tr>
                        <td>XXXXXXX</td>
                        <td>XXXXXXX</td>
                        <td>XXXXXXX</td>
                        <td>
                            <button class="action-button delete"><img src="../Recursos/delete.png" alt="Delete"></button>
                            <button class="action-button visualize"><img src="../Recursos/visualize.png" alt="Visualize"></button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </main>
    </div>
</body>
</html>const email = "professor@email.com"; // simulação do e-mail da sessão

window.onload = listarTurmas;

function listarTurmas() {
    axios.get(`http://localhost:8080/turmas/get/${email}`)
        .then(response => {
            const turmas = response.data;
            const tabela = document.getElementById("tabela-turmas");
            tabela.innerHTML = "";
            turmas.forEach(turma => {
                const tr = document.createElement("tr");

                const tdId = document.createElement("td");
                tdId.textContent = turma.id;

                const tdNome = document.createElement("td");
                tdNome.textContent = turma.nome;

                const tdAcoes = document.createElement("td");

                const botaoExcluir = document.createElement("button");
                botaoExcluir.textContent = "Excluir";
                botaoExcluir.className = "action-button";
                botaoExcluir.onclick = () => deletarTurma(turma.id);

                const botaoAtualizar = document.createElement("button");
                botaoAtualizar.textContent = "Atualizar";
                botaoAtualizar.className = "action-button";
                botaoAtualizar.onclick = () => atualizarTurma(turma.id);

                tdAcoes.appendChild(botaoExcluir);
                tdAcoes.appendChild(botaoAtualizar);

                tr.appendChild(tdId);
                tr.appendChild(tdNome);
                tr.appendChild(tdAcoes);

                tabela.appendChild(tr);
            });
        })
        .catch(error => {
            console.error("Erro ao listar turmas:", error);
        });
}

function cadastrar() {
    const nome = document.getElementById("novaTurma").value;
    if (!nome.trim()) {
        alert("Digite o nome da turma.");
        return;
    }

    // Simulando recuperação do ID do professor por e-mail
    axios.get(`http://localhost:8080/professores/get/${email}`)
        .then(res => {
            const idProfessor = res.data.id;
            return axios.post("http://localhost:8080/turmas", {
                nome: nome,
                id_professor: idProfessor
            });
        })
        .then(() => {
            alert("Turma cadastrada com sucesso!");
            listarTurmas();
        })
        .catch(error => {
            console.error("Erro ao cadastrar turma:", error);
        });
}

function deletarTurma(id) {
    if (!confirm("Tem certeza que deseja deletar esta turma?")) return;

    axios.delete(`http://localhost:8080/turmas/deletar/${id}`)
        .then(() => {
            alert("Turma deletada!");
            listarTurmas();
        })
        .catch(error => {
            console.error("Erro ao deletar turma:", error);
        });
}

function atualizarTurma(id) {
    const novoNome = prompt("Digite o novo nome da turma:");
    if (!novoNome || !novoNome.trim()) return;

    axios.put(`http://localhost:8080/turmas/atualizar/${id}`, {
        nome: novoNome
    })
    .then(() => {
        alert("Turma atualizada!");
        listarTurmas();
    })
    .catch(error => {
        console.error("Erro ao atualizar turma:", error);
    });
}
