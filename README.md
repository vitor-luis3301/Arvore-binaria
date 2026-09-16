# Implementação de Arvore binária em Java
Trabalho apresentado para a disciplina de Resolução de Problemas Estruturados em Computação do curso de Bacharelado em Ciência da Computação da Pontificia Universidade Católica do Paraná.

## Explicação do código

O programa consiste de três classes: `Node`, `Tree`, e `Main`.

### Node

A classe `Node` possui três parametros: 
- `value (int)`: O valor a ser armazenado no nó.
- `left (Node)`: Referencia ao nó filho localizado a esquerda da árvore.
- `right (Node)`: Referencia ao nó filho localizado a direita da árvore.

O construtor da classe `Node` requer um `int` como parametro para ser o valor do nó.

### Tree

A classe `Tree` só tem o parametro `root (Node)`, usado para definir o nó raiz da árvore.

A classe `Tree` tem as seguintes funções privadas:

- `void append(Node newNode)`: Adiciona um novo nó à árvore. Se a árvore não tiver nenhum nó (`root == null`), ela faz o novo nó (`newNode`) a raiz da árvore. Caso contrário, a função percorre a árvore até achar um lugar para o novo nó, verificando se o valor do novo nó é maior que ou igual ao valor do nó sendo analizado no momento. Se sim, ele verifica se o nó sendo analizado possui filhos à direita, caso não tenha ele coloca o novo nó como filho, do contrário ele verifica o próximo nó à direita. Caso o valor seja menor, ele faz a mesma verificação para a esquerda.
- `void preorderTraversalPrint(Node node)`: É uma função recursiva que atravessa a árvore com o nó dado como seu argumento sendo a raiz. Ela primeiro verifica se o nó é nulo e encerra a execução se for o caso. Se não, ela imprime o valor do nó, e chama a si mesma com os nós filhos da esquerda e direita respectivamente. Essa função segue o principio de Pré ordem para atravessar a árvore.
- `void replaceChild(Node parent, Node oldChild, Node newChild)`: Essa função é uma função helper para a remoção de nós da árvore. Ela reorganiza a árvore fazendo com que um nó pai tenha um dos seus dois filhos substituidos por um outro.

A classe `Tree` tem as seguintes funções públicas:

- `void insert(int value)`: Cria um novo nó com o valor inserido como argumento e o adiciona à árvore com a função privada `append()`
- `void printTree()`: Imprime a árvore seguindo o principio de Pré Ordem rodando a função `preorderTraversalPrint()` com a raiz como argumento.
- `boolean has(int value)`: Percorre a árvore a partir da raiz para encontrar o valor do argumento em um nó da árvore. Para cada nó que analiza, Se o valor do argumento for maior que o valor do nó sendo analizado, a função avança à direita. Caso contrário, avança à esquerda. Isso continua em loop até que ou os valores sejam iguais ou nada seja encontrado (quando a referencia do nó a ser analizado é igual a `null`). Após o loop, se nada for encontrado, retorna `false`, caso contrario retorna `true`.
- `void remove(int value)`: Remove da árvore um nó com o valor do argumento. Primeiro, ele procura o nó correspondente, se não o encontra encerra a execução. Quando encontra, identifica se o nó encontrado (o nó com o valor a ser eliminado) é um nó folha (lê-se, um nó que não tem filhos na esquerda e na direita), ou se têm filhos na esquerda, ou na direita, ou em ambos. Se é folha, usa a função privada `replaceChild()` para substituir a referencia do nó a ser eliminado como `null` no nó pai (ou seja, o nó pai se torna um nó folha). Se tem filhos ou na esquerda ou na direita, substitui o nó a ser eliminado com seu nó filho do lado respectivo (o nó filho do nó a ser eliminado se torna filho do nó pai). Se o nó a ser eliminado tem filhos na esquerda e na direita, a função identifica qual é o nó de maior valor na subárvore à esquerda do nó, e utiliza a função `replaceChild` para substituir por esse nó na árvore.

### Main

A classe `Main` possui apenas a função principal que demonstra as funcionalidades das classes. Ela insere alguns elementos, imprime a árvore, verifica se certos valores existem na árvore, remove um valor e imprime de novo para confirmar a exclusão.
