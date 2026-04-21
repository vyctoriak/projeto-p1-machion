# Projeto P1 — Estruturas de Dados

**Sistema de Gerenciamento de Processos de uma Central de Atendimento com Prioridade**

Disciplina: Estruturas de Dados — Prof.(a) Andreia Machion  
1º Semestre de 2026 — FATEC Carapicuíba

# Integrantes

- Vyctoria Karina da Silva - RA 1430482613042
- Pedro Henrique de Oliveira - RA 1430482511040
- Adson Lima - RA 1430482511035
- Mariana Borgato - RA 1430482511046
- Pietro Zonta - RA 1430482511007

## Estrutura do Projeto

```
src/
├── Processo.java              # Classe de domínio (protocolo, solicitante, prioridade)
├── VetorDinamico.java         # Vetor dinâmico com redimensionamento 
├── PilhaVaziaException.java   # Exceção para operações em pilha vazia
├── PilhaProcesso.java         # Pilha sobre VetorDinamico
├── PilhaPrioridade.java       # Pilha por nível de prioridade
├── CentralAtendimento.java    # Lógica principal
├── MenuCentral.java           # Menu interativo no console
├── TesteVetorDinamico.java    # Teste da Etapa 1 (redimensionamentos)
└── TesteIntegracao.java       # Teste da Etapa 3 (prioridade + desfazer + erros)
```

## Como compilar e executar

Requer **Java 11** ou superior.

**Pode ser diferente dependendo do seu sistema operacional**

```bash
# Compilar
javac src/*.java -d out/

# Executar o menu interativo
java -cp out src.MenuCentral

# Executar teste do VetorDinamico
java -cp out src.TesteVetorDinamico

# Executar teste de integração
java -cp out src.TesteIntegracao
```

## Etapas

1. **Etapa 1** — Classe `Processo` + `VetorDinamico` com redimensionamento
2. **Etapa 2** — `PilhaProcesso` + `CentralAtendimento` com desfazer
3. **Etapa 3** — `PilhaPrioridade` (urgente > normal > baixa) + integração final
