    package com.example.safezone;

    import android.util.Log;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Arrays;


    public class SequenceManager{

            static private List<Eventos> teste = Arrays.asList(Eventos.SCREEN_OFF, Eventos.SCREEN_ON,Eventos.SCREEN_OFF);
            static private List<Eventos> testeb = Arrays.asList(Eventos.SCREEN_ON, Eventos.SCREEN_OFF,Eventos.SCREEN_ON);

            private LinkedList<Eventos> sequencia = new LinkedList<>();

            private int contagem = 0;

            private long tempoInicial;
            private long tempoFinal;
            private long tempoDecorrido;


            public boolean add(Eventos eventos){
                contagem++;
                sequencia.add(eventos);

                if(contagem == 1){tempoInicial = System.currentTimeMillis(); Log.d("Timer","Ligou agora");}

                if(sequencia.size()>teste.size()){sequencia.removeFirst();}

                Log.d("SEQUENCE","adicionado " + sequencia.toString());
                Log.d("Timer","Ligado " + tempoInicial);
                if ((sequencia.equals(teste)) || (sequencia.equals(testeb))){
                    tempoFinal = System.currentTimeMillis();
                    Log.d("Timer","Tempo Final " + tempoFinal);
                    tempoDecorrido = tempoFinal- tempoInicial;
                    Log.d("Timer","Tempo Decorrido " + tempoDecorrido);

                    if(tempoDecorrido < 3000) {

                        sequencia.clear();
                        contagem=0;
                        Log.d("Timer", "o tempo decorrido é menor?");
                        return true;
                    }

                    contagem=0;
                    sequencia.clear();
                }
                return false;

            }



        public enum Eventos{
            SCREEN_ON,
            SCREEN_OFF,
            VOLUME_UP,
            VOLUME_DOWN
        }
    }

