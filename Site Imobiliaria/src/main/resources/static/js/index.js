// Frases aleatórias para o título e o parágrafo com 2 frases de Viva Imóveis
const titles = [
    "Transforme Seu Sonho Em Realidade",
    "Encontre o Lar Perfeito com a Viva Imóveis",
    "A Casa dos Seus Sonhos Está Aqui",
    "Seu Novo Lar Espera Por Você com a Viva Imóveis",
    "O Imóvel Ideal Está Ao Seu Alcance"
];

const texts = [
    "Explore as melhores opções de imóveis à venda e para alugar, e encontre o lugar perfeito para sua nova história.",
    "Sua jornada para encontrar o lar dos seus sonhos começa aqui. Navegue pelas melhores ofertas de imóveis da Viva Imóveis.",
    "Deixe-nos ajudar você a encontrar a casa que sempre quis. Descubra opções de imóveis que atendem às suas necessidades.",
    "Com as melhores opções de imóveis, o seu novo lar está mais próximo do que nunca. Faça sua escolha com confiança.",
    "Sua busca pelo imóvel ideal começa agora. Encontre a casa perfeita para o seu estilo de vida, com confiança e facilidade."
];

// Função para escolher uma frase aleatória
function getRandomPhrase(phrases) {
    return phrases[Math.floor(Math.random() * phrases.length)];
}

// Atribui as frases aleatórias ao título e ao texto
document.getElementById("hero-title").innerText = getRandomPhrase(titles);
document.getElementById("hero-text").innerText = getRandomPhrase(texts);
