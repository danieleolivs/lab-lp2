package br.edu.ufcg.computacao.p2lp2.Exception;

import br.edu.ufcg.computacao.p2lp2.hotelcalifornia.HotelCaliforniaController;

public class HotelCaliforniaException extends RuntimeException{
    private static final long serialVersion = 1149241039409861914L;

    public HotelCaliforniaException(String msg){
        super(msg);
    }

    public HotelCaliforniaException(String msg, Throwable cause){
        super(msg, cause);
    }
}
