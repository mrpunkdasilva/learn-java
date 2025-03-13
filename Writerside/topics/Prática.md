# Prática 1

Nesta prática, vamos criar e configurar máquinas virtuais.

## Conhecendo ferramentas

Para fazer a virtualização de sistemas operacionais, temos alguns programas disponíveis:

- **Windows**: 
  - VirtualBox
  - VMWare
  - Parallels Desktop
- **Linux**:
  - VirtualBox
  - GNOME Boxes 
  - Virtual Machine Manager

> Há casos em que o VirtualBox falha por razões desconhecidas, então é melhor ter mais de uma opção disponível.
> {style="note"}

## Vamos começar {id="vamos-come-ar_1"}

### Requisitos dos sistemas {id="requisitos-dos-sistemas_1"}

Confira os requisitos dos sistemas operacionais que serão usados:

- [Windows 10](https://support.microsoft.com/pt-br/windows/requisitos-do-sistema-do-windows-10-6d4e9a79-66bf-7950-467c-795cf0386715)
- [Ubuntu Desktop](https://ubuntu.com/server/docs/system-requirements)

> É importante verificar os requisitos mínimos para garantir que sua máquina virtual tenha recursos suficientes para executar o sistema operacional escolhido.
> {style="note"}

### Instalando a ferramenta {id="instalando-a-ferramenta_1"}

Vamos usar o VirtualBox.

- Para [Windows](https://download.virtualbox.org/virtualbox/7.1.6/VirtualBox-7.1.6-167084-Win.exe)
- Para [Linux](https://www.virtualbox.org/wiki/Linux_Downloads)

> O VirtualBox é uma ferramenta de virtualização gratuita e de código aberto, adequada para usuários iniciantes e avançados.
> {style="note"}

### Instalar ISOs (Windows e Ubuntu) {id="instalar-isos-windows-e-ubuntu_1"}

- [Windows](https://www.microsoft.com/pt-br/software-download/windows10ISO)

> Na ISO oficial do Windows, o link acima, vêm todas as versões.
> {style="note"}

- [Ubuntu Desktop](https://ubuntu.com/download/desktop)

> Certifique-se de baixar a versão mais recente e estável do Ubuntu Desktop para garantir compatibilidade e suporte.
> {style="note"}

### Criando Máquinas Virtuais {id="criando-m-quinas-virtuais_1"}
#### Windows {id="windows_1_1"}

1. Com o VirtualBox aberto, pressione: <kbd>CTRL</kbd> + <kbd>N</kbd>
> Você pode acessar a opção também por: `Machine > Add`
> {style="note"}
2. Definir nome, sistema e versão:

![Tela de criação de máquina virtual no VirtualBox](Captura de tela de 2025-02-28 19-52-13.png)

> Escolha um nome descritivo para sua máquina virtual e selecione a versão correta do Windows que você planeja instalar.
> {style="note"}

3. Agora vamos definir a memória RAM. É bom deixarmos no mínimo 4GB 

> Atente-se que computadores não lidam bem com números ímpares.
> {style="note"}

![Configuração de memória RAM para a máquina virtual](Captura de tela de 2025-02-28 19-52-35.png)

> A quantidade de RAM alocada afetará diretamente o desempenho da sua máquina virtual. Certifique-se de deixar RAM suficiente para o seu sistema host também.
> {style="note"}

4. Agora definimos o espaço de armazenamento, disco rígido:

![Configuração de disco rígido para a máquina virtual](Captura de tela de 2025-02-28 19-52-57.png)

> O tamanho do disco virtual deve ser suficiente para o sistema operacional e os programas que você planeja instalar. Você pode aumentar o tamanho posteriormente, mas é mais complicado diminuí-lo.
> {style="note"}

5. Com tudo criado, basta ir em `Finish`:

6. Temos então nossa primeira máquina virtual criada:

![Máquina virtual Windows criada no VirtualBox](Captura de tela de 2025-02-28 19-53-04.png)

> Parabéns! Você criou sua primeira máquina virtual. Agora está pronta para receber o sistema operacional.
> {style="note"}

---

#### Ubuntu {id="ubuntu_1_1"}

1. Com o VirtualBox aberto, pressione: <kbd>CTRL</kbd> + <kbd>N</kbd>
> Você pode acessar a opção também por: `Machine > Add`
> {style="note"}
2. Definir nome, sistema e versão:

![Tela de criação de máquina virtual Ubuntu no VirtualBox](Captura de tela de 2025-02-28 19-54-21.png)

> Certifique-se de selecionar "Ubuntu" como o tipo de sistema e escolha a versão correta que você planeja instalar.
> {style="note"}

3. Agora vamos definir a memória RAM. É bom deixarmos no mínimo 4GB 

> Atente-se que computadores não lidam bem com números ímpares.
> {style="note"}

![Configuração de memória RAM para a máquina virtual Ubuntu](Captura de tela de 2025-02-28 19-54-54.png)

> O Ubuntu geralmente requer menos RAM que o Windows, mas 4GB é uma boa quantidade para garantir um desempenho suave.
> {style="note"}

4. Agora definimos o espaço de armazenamento, disco rígido:

![Configuração de disco rígido para a máquina virtual Ubuntu](Captura de tela de 2025-02-28 19-55-44.png)

> O Ubuntu geralmente requer menos espaço em disco que o Windows. 20GB é suficiente para uma instalação básica, mas considere alocar mais se planeja instalar muitos programas.
> {style="note"}

5. Com tudo criado, basta ir em `Finish`:

6. Temos então nossa primeira máquina virtual criada:

![Máquina virtual Ubuntu criada no VirtualBox](Captura de tela de 2025-02-28 21-41-38.png)

> Sua máquina virtual Ubuntu está pronta para receber o sistema operacional. O próximo passo será iniciar a instalação do Ubuntu.
> {style="note"}

### Logar nas VMs recém-criadas

Ao executar as máquinas, nenhum sistema será inicializado, já que não foi definida nenhuma ISO (Imagem de um Sistema Operacional). Assim, as máquinas ficam em seu estado puro, sem nenhum sistema operacional, e são inutilizáveis.

#### Windows {id="windows_2_1"}

![Tela inicial da máquina virtual Windows sem sistema operacional](Captura de tela de 2025-02-28 19-57-31.png)

> Esta tela indica que a máquina virtual está pronta, mas ainda não tem um sistema operacional instalado.
> {style="note"}

#### Ubuntu {id="ubuntu_2_1"}

![Tela inicial da máquina virtual Ubuntu sem sistema operacional](Captura de tela de 2025-02-28 19-57-15.png)

> Semelhante à máquina Windows, esta tela mostra que a máquina virtual Ubuntu está criada, mas ainda precisa de um sistema operacional.
> {style="note"}

### Configurando VMs para os SOs {id="configurando-vms-para-os-sos_1"}

Para tornar as VMs utilizáveis, precisamos definir as ISOs que serão as imagens do sistema usadas para instalar o sistema operacional.

#### Windows {id="windows_3_1"}

Com a máquina em execução e este pop-up aparecendo, selecionamos onde está a ISO do Windows que foi baixada nos passos anteriores:

![Seleção da ISO do Windows para instalação](Captura de tela de 2025-02-28 20-40-42.png)

> Certifique-se de selecionar a ISO correta do Windows que você baixou anteriormente. Isso iniciará o processo de instalação do Windows na sua máquina virtual.
> {style="note"}

#### Ubuntu {id="ubuntu_4"}

Com a máquina em execução e este pop-up aparecendo, selecionamos onde está a ISO do Ubuntu que foi baixada nos passos anteriores:

![Seleção da ISO do Ubuntu para instalação](Captura de tela de 2025-02-28 19-58-19.png)

> Selecione a ISO do Ubuntu que você baixou. Isso iniciará o processo de instalação do Ubuntu na sua máquina virtual.
> {style="note"}

### Logar nas VMs

Agora, com tudo o que vimos, podemos fazer a instalação do sistema. Para isso, devemos logar ou entrar nas máquinas que criamos e então fazer as etapas de instalação do Windows e Ubuntu.

#### Windows

![Tela inicial de instalação do Windows](VirtualBox_punk_windows_28_02_2025_20_41_23.png)

> Esta é a tela inicial de instalação do Windows. A partir daqui, você seguirá as etapas para configurar seu sistema Windows.
> {style="note"}

![Seleção de idioma, formato de hora e moeda, e layout de teclado](VirtualBox_punk_windows_28_02_2025_20_41_46.png)

> Escolha as opções que melhor se adequam à sua região e preferências de idioma.
> {style="note"}

![Botão "Instalar agora" para iniciar a instalação do Windows](VirtualBox_punk_windows_28_02_2025_20_41_53.png)

> Clique em "Instalar agora" para começar o processo de instalação do Windows.
> {style="note"}

![Inserção da chave do produto Windows](VirtualBox_punk_windows_28_02_2025_20_42_11.png)

> Se você tiver uma chave do produto, insira-a aqui. Caso contrário, você pode pular esta etapa e ativar o Windows posteriormente.
> {style="note"}

![Seleção da versão do Windows a ser instalada](VirtualBox_punk_windows_28_02_2025_20_42_15.png)

> Escolha a versão do Windows que deseja instalar. Para uso pessoal, "Windows 10 Home" geralmente é suficiente.
> {style="note"}

![Aceitação dos termos de licença do Windows](VirtualBox_punk_windows_28_02_2025_20_43_36.png)

> Leia e aceite os termos de licença para prosseguir com a instalação.
> {style="note"}

![Escolha do tipo de instalação: Atualização ou Personalizada](VirtualBox_punk_windows_28_02_2025_20_43_46.png)

> Para uma nova instalação em uma máquina virtual, escolha "Instalação Personalizada".
> {style="note"}

![Seleção do disco onde o Windows será instalado](VirtualBox_punk_windows_28_02_2025_20_43_53.png)

> Selecione o disco virtual que você criou anteriormente para instalar o Windows.
> {style="note"}

![Progresso da instalação do Windows](VirtualBox_punk_windows_28_02_2025_20_43_59.png)

> A instalação do Windows está em andamento. Isso pode levar alguns minutos.
> {style="note"}

![Reinicialização do sistema após a instalação inicial](VirtualBox_punk_windows_28_02_2025_20_49_12.png)

> Após a instalação inicial, o sistema irá

## Vamos começar

### Requisitos dos sistemas

Confira os requisitos dos sistemas operacionais que serão usados:

- [Windows 10](https://support.microsoft.com/pt-br/windows/requisitos-do-sistema-do-windows-10-6d4e9a79-66bf-7950-467c-795cf0386715)
- [Ubuntu Desktop](https://ubuntu.com/server/docs/system-requirements)

### Instalando a ferramenta

Vamos usar o VirtualBox.

- Para [Windows](https://download.virtualbox.org/virtualbox/7.1.6/VirtualBox-7.1.6-167084-Win.exe)
- Para [Linux](https://www.virtualbox.org/wiki/Linux_Downloads)

### Instalar ISOs (Windows e Ubuntu)

- [Windows](https://www.microsoft.com/pt-br/software-download/windows10ISO)

> Na ISO oficial do Windows, o link acima, vêm todas as versões.
> {style="note"}

- [Ubuntu Desktop](https://ubuntu.com/download/desktop)

### Criando Máquinas Virtuais
#### Windows {id="windows_1"}

1. Com o VirtualBox aberto, pressione: <kbd>CTRL</kbd> + <kbd>N</kbd>
> Você pode acessar a opção também por: `Machine > Add`
> {style="note"}
2. Definir nome, sistema e versão:

![Tela de criação de máquina virtual no VirtualBox](Captura de tela de 2025-02-28 19-52-13.png)

3. Agora vamos definir a memória RAM. É bom deixarmos no mínimo 4GB 

> Atente-se que computadores não lidam bem com números ímpares.
> {style="note"}

![Configuração de memória RAM para a máquina virtual](Captura de tela de 2025-02-28 19-52-35.png)

4. Agora definimos o espaço de armazenamento, disco rígido:

![Configuração de disco rígido para a máquina virtual](Captura de tela de 2025-02-28 19-52-57.png)

5. Com tudo criado, basta ir em `Finish`:

6. Temos então nossa primeira máquina virtual criada:

![Máquina virtual Windows criada no VirtualBox](Captura de tela de 2025-02-28 19-53-04.png)

---

#### Ubuntu {id="ubuntu_1"}

1. Com o VirtualBox aberto, pressione: <kbd>CTRL</kbd> + <kbd>N</kbd>
> Você pode acessar a opção também por: `Machine > Add`
> {style="note"}
2. Definir nome, sistema e versão:

![Tela de criação de máquina virtual Ubuntu no VirtualBox](Captura de tela de 2025-02-28 19-54-21.png)

3. Agora vamos definir a memória RAM. É bom deixarmos no mínimo 4GB 

> Atente-se que computadores não lidam bem com números ímpares.
> {style="note"}

![Configuração de memória RAM para a máquina virtual Ubuntu](Captura de tela de 2025-02-28 19-54-54.png)

4. Agora definimos o espaço de armazenamento, disco rígido:

![Configuração de disco rígido para a máquina virtual Ubuntu](Captura de tela de 2025-02-28 19-55-44.png)

5. Com tudo criado, basta ir em `Finish`:

6. Temos então nossa primeira máquina virtual criada:

![Máquina virtual Ubuntu criada no VirtualBox](Captura de tela de 2025-02-28 21-41-38.png)

### Logar nas VMs recém-criadas {id="logar-nas-vms-rec-m-criadas_1"}

Ao executar as máquinas, nenhum sistema será inicializado, já que não foi definida nenhuma ISO (Imagem de um Sistema Operacional). Assim, as máquinas ficam em seu estado puro, sem nenhum sistema operacional, e são inutilizáveis.

#### Windows {id="windows_2"}

![Tela inicial da máquina virtual Windows sem sistema operacional](Captura de tela de 2025-02-28 19-57-31.png)

#### Ubuntu {id="ubuntu_2"}

![Tela inicial da máquina virtual Ubuntu sem sistema operacional](Captura de tela de 2025-02-28 19-57-15.png)

### Configurando VMs para os SOs

Para tornar as VMs utilizáveis, precisamos definir as ISOs que serão as imagens do sistema usadas para instalar o sistema operacional.

#### Windows {id="windows_3"}

Com a máquina em execução e este pop-up aparecendo, selecionamos onde está a ISO do Windows que foi baixada nos passos anteriores:

![Seleção da ISO do Windows para instalação](Captura de tela de 2025-02-28 20-40-42.png)

#### Ubuntu

Com a máquina em execução e este pop-up aparecendo, selecionamos onde está a ISO do Ubuntu que foi baixada nos passos anteriores:

![Seleção da ISO do Ubuntu para instalação](Captura de tela de 2025-02-28 19-58-19.png)
### Logar nas VMs {id="logar-nas-vms_1"}

Agora, com tudo o que vimos, podemos fazer a instalação do sistema. Para isso, devemos logar ou entrar nas máquinas que criamos e então fazer as etapas de instalação do Windows e Ubuntu.

#### Windows {id="windows_4"}

![Tela inicial de instalação do Windows](VirtualBox_punk_windows_28_02_2025_20_41_23.png)

![Seleção de idioma, formato de hora e moeda, e layout de teclado](VirtualBox_punk_windows_28_02_2025_20_41_46.png)

![Botão "Instalar agora" para iniciar a instalação do Windows](VirtualBox_punk_windows_28_02_2025_20_41_53.png)

![Inserção da chave do produto Windows](VirtualBox_punk_windows_28_02_2025_20_42_11.png)

![Seleção da versão do Windows a ser instalada](VirtualBox_punk_windows_28_02_2025_20_42_15.png)

![Aceitação dos termos de licença do Windows](VirtualBox_punk_windows_28_02_2025_20_43_36.png)

![Escolha do tipo de instalação: Atualização ou Personalizada](VirtualBox_punk_windows_28_02_2025_20_43_46.png)

![Seleção do disco onde o Windows será instalado](VirtualBox_punk_windows_28_02_2025_20_43_53.png)

![Progresso da instalação do Windows](VirtualBox_punk_windows_28_02_2025_20_43_59.png)

![Reinicialização do sistema após a instalação inicial](VirtualBox_punk_windows_28_02_2025_20_49_12.png)

![Configuração inicial: Seleção de região](VirtualBox_punk_windows_28_02_2025_20_54_51.png)

![Configuração inicial: Confirmação do layout de teclado](VirtualBox_punk_windows_28_02_2025_20_55_27.png)

![Configuração inicial: Opção de adicionar um segundo layout de teclado](VirtualBox_punk_windows_28_02_2025_20_56_13.png)

![Configuração de rede: Conexão à internet](VirtualBox_punk_windows_28_02_2025_21_00_27.png)

![Configuração de conta: Opções de login](VirtualBox_punk_windows_28_02_2025_21_00_55.png)


![Definição de senha para a conta local](VirtualBox_punk_windows_28_02_2025_21_01_42.png)

![Configuração de perguntas de segurança](VirtualBox_punk_windows_28_02_2025_21_02_20.png)

![Configurações de privacidade: Escolha de permissões](VirtualBox_punk_windows_28_02_2025_21_02_37.png)

![Configuração de experiência personalizada](VirtualBox_punk_windows_28_02_2025_21_03_02.png)

![Configuração do assistente digital Cortana](VirtualBox_punk_windows_28_02_2025_21_03_11.png)

![Finalização da configuração do Windows](VirtualBox_punk_windows_28_02_2025_21_03_19.png)

![Área de trabalho do Windows após a instalação completa](VirtualBox_punk_windows_28_02_2025_21_07_43.png)

![Menu Iniciar do Windows recém-instalado e digite "Configurações"](VirtualBox_punk_windows_28_02_2025_21_07_55.png)

![Vá em "Sistema"](VirtualBox_punk_windows_28_02_2025_21_08_24.png)

![Na seção "Sobre" do sistema podemos ver as configurações da maquina que foi instalada](VirtualBox_punk_windows_28_02_2025_21_08_36.png)


#### Ubuntu {id="ubuntu_3"}

- Configurações de instalação:
![Assim que rodarmos a máquina, vai aparecer a tela do GRUB e então selecionamos a primeira opção](VirtualBox_punk_ubuntu_28_02_2025_19_58_36.png)

<note>
O GRUB (Grand Unified Bootloader) é o menu de inicialização que aparece quando você inicia o sistema Ubuntu. Ele permite que você escolha entre diferentes opções de inicialização.

- A primeira opção geralmente é "Ubuntu", que inicia o sistema normalmente.
- Outras opções podem incluir modos de recuperação ou versões anteriores do kernel.

Para a instalação padrão, selecione a primeira opção "Ubuntu" e pressione Enter para continuar.
</note>

![Selecionamos o idioma](VirtualBox_punk_ubuntu_28_02_2025_20_00_21.png)

![Na parte de Acessibilidade, é só se for necessário](VirtualBox_punk_ubuntu_28_02_2025_20_00_29.png)

![Selecionaremos agora o layout do teclado](VirtualBox_punk_ubuntu_28_02_2025_20_00_46.png)

![Deixe na forma padrão de conexão](VirtualBox_punk_ubuntu_28_02_2025_20_00_50.png)

![Aperte em "Next" ou "Próximo", deixe selecionada a forma padrão de instalação](VirtualBox_punk_ubuntu_28_02_2025_20_00_57.png)

![Deixe na forma interativa de instalação, ou seja, primeira opção](VirtualBox_punk_ubuntu_28_02_2025_20_01_06.png)

![Para a próxima parte, é onde definimos se queremos que ao instalar o Ubuntu sejam instalados aplicativos adicionais, além dos básicos como navegador e outros utilitários. Neste caso, deixe na opção padrão](VirtualBox_punk_ubuntu_28_02_2025_20_01_12.png)

![Nesta etapa, selecione todas as opções, que são para instalar softwares de terceiros e download de formatos de mídia adicionais](VirtualBox_punk_ubuntu_28_02_2025_20_01_18.png)

![Nesta parte é a definição de se iremos instalar limpando o disco ou se faremos o particionamento do disco. Deixe a opção como padrão e aperte em next](VirtualBox_punk_ubuntu_28_02_2025_20_01_27.png)

![Agora na parte de criação de conta, defina suas credenciais](VirtualBox_punk_ubuntu_28_02_2025_20_03_04.png)

![Agora é só fazermos a configuração do fuso horário, ou seja, do tempo que o computador irá usar](VirtualBox_punk_ubuntu_28_02_2025_20_03_28.png)

![Nesta página será apenas para mostrar o resumo da instalação, uma visão geral das configurações para instalação](VirtualBox_punk_ubuntu_28_02_2025_20_03_34.png)

![Aqui é a etapa em que o sistema será instalado, pode demorar uns 30 minutos](VirtualBox_punk_ubuntu_28_02_2025_20_03_38.png)

![Com a etapa anterior concluída, o sistema já foi instalado e já podemos reiniciar a máquina](VirtualBox_punk_ubuntu_28_02_2025_20_29_53.png)

![Ao reiniciarmos a máquina, aparece então a tela de login do usuário que foi criado](VirtualBox_punk_ubuntu_28_02_2025_20_32_34.png)

![Ao logarmos, temos a visão desta tela](VirtualBox_punk_ubuntu_28_02_2025_20_34_46.png)

![Nessa parte, basta passarmos adiante - clique em Skip ou Prosseguir](VirtualBox_punk_ubuntu_28_02_2025_20_35_05.png)

![Aperte a tecla Super do seu teclado e digite "settings" ou "configurações" e aperte no primeiro item](VirtualBox_punk_ubuntu_28_02_2025_20_37_43.png)

![Vá na parte inferior do menu lateral esquerdo e aperte em "System" ou "Sistema" e em seguida aperte em "About" ou "Sobre"](VirtualBox_punk_ubuntu_28_02_2025_20_37_55.png)

![Assim podemos visualizar as informações do sistema que está instalado](VirtualBox_punk_ubuntu_28_02_2025_20_38_18.png)