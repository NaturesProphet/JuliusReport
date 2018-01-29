# JuliusReport

Autor: Mateus Garcia ( github.com/NaturesProphet )
E-Mail: mateus.gigainfo@gmail.com

Sistema de organização e controle para auxiliar no controle financeiro de se manter um ou mais veículos particulares de diversos tipos.

O Sistema utiliza um banco de dados simples, portátil e muito prático, o SQLITE 3, que dispensa qualquer tipo de instalação ou configuração, o que somado ao fato de ter sido escrito em Java, torna este sistema ALTAMENTE PORTÁVEL.

O caminho para o arquivo do banco de dados (que consiste em um simples arquivo com extensão '.db') é configuravel pelo usuário, dispensando qualquer intervensão do Desenvolvedor. Este caminho pode ser configurado de duas maneiras diferentes e fáceis:
1) na interface de login, clicar no botão 'configurações' no canto inferior esquerdo. irá abrir uma janela exibindo o caminho do banco atualmente utilizado, e vc poderá alterá-lo manualmente ou clicando no botão 'buscar' e apontar para seu arquivo .db por lá.
2) O caminho é definido em um simples arquivo de texto na pasta raiz do programa, um arquivo chamado 'DB.dat'. Basta abri-lo com um editor de textos e então digitar manualmente o caminho do banco na primeira linha deste arquivo.

ATENÇÃO: obviamente o sistema depende deste arquivo DB.dat em seu devido local apontando para seu respectivo arquivo .db (este pode estar em qualquer lugar com permissão de escrita que o Usuário quiser).

Em caso do arquivo .db se corromper, existe um backup virgem deste arquivo compactado contendo a estrutura de dados pronta para uso, basta portanto descompacta-lo e apontar o arquivo DB.dat para ele. Este backup se encontra na pasta Raiz do sistema também, chamado 'Backup_JReport.db'.


Este sistema foi desenvolvido totalmente em uma Plataforma Linux usando a IDE Netbeans, não testei em plataformas Windows ou mac, mas por ser Java e usar o SQLITE muito certamente que rodará tranquilamente nessas maquinas também.

LINUX RULES!
