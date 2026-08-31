/** 
 * MIT License
 *
 * Copyright(c) 2022-6 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

 /**
  * Primeira versão da classe Hora para demonstração de conceitos básicos de classe e objetos: 
  * atributos, métodos, parâmetros, documentação.
  * Esta classe tem a responsabilidade de armazenar um horário do dia, considerando 24h.
  * Pode <b> e deve </b> ser melhorada com futuros conhecimentos.
  */
  public class Hora {

    //#region atributos
    private int horas;
    private int minutos;
    private int segundos;
    //#endregion
    
    //#region métodos
    
    /**
     * Construtor. Recebe os valores desejados para hora, minuto e segundo e executa o método de ajuste de hora.
     * Em caso de valores inválidos, a hora retorna para 00:00:00.
     * @param horas A hora desejada (0 a 23)
     * @param minutos O minuto desejado (0 a 59)
     * @param segundos O segundo desejado (0 a 59)
     */
    public Hora(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        if(!ehValida())
            horas = minutos = segundos = 0;
    }

    /**
     * Valida a hora armazenada atualmente, de acordo com as regras habituais de hora, minuto e segundo. 
     * Retorna TRUE ou FALSE conforme validade da hora.
     * @return TRUE para hora válida, FALSE para hora inválida.
     */
    private boolean ehValida() {
        return ((horas >= 0 && horas <= 23) && 
            (minutos >= 0 && minutos <= 59) && 
            (segundos >= 0 && segundos <= 59));
    }

    

    /**
     * Verifica se esta hora encontra-se à frente de outra considerando um dia de 24h. 
     * Perceba que a ação é feita a partir da comparação das strings formatadas das horas.
     * Retorna TRUE ou FALSE conforme esta hora esteja na frente.
     * @param outra A outra hora a ser comparada com esta
     * @return TRUE se esta hora está à frente no relógio, FALSE caso contrário.
     */
    public boolean estahNaFrenteDe(Hora outra){
       if(this.horas > outra.horas)
            return true;
       else if(this.minutos > outra.minutos)
            return true;
       else if(this.segundos > outra.segundos)
            return true;

       return false;
	}
    
    /**
     * Incrementa uma quantidade de segundos a uma hora existente, retornando a nova hora. Não modifica a hora já existente.
     * Quantidades menores ou iguais a 0 são ignoradas e é retornada uma hora idêntica à atual.
     * @param quantidadeSegundos Quantidade de segundos a incrementar (>0)
     * @return Uma nova hora com os segundos incrementados, podendo ser igual à hora atual em caso de valores não positivos.
     */
    public Hora incrementar(int minutos){
        int horasAMais;
        int sobraMinutos;
        int novasHoras;

        if(minutos < 0)
            minutos = 0;
        minutos += this.minutos;

        horasAMais = minutos / 60;
        sobraMinutos = minutos % 60;

        novasHoras = horas + horasAMais;
       
        return new Hora(novasHoras, sobraMinutos, segundos);
    }

    /**
     * Retorna uma hora formatada em HH:MM:SS
     * @return Uma string com a hora formatada como indicado.
     */
    String horaFormatada(){
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
    //#endregion
}
