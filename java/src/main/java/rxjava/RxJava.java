package rxjava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Unit test for simple App.
 */
public class RxJava {

    private String result;

    @Test
    public void observableJust() {

        Observable<String> observable = Observable.just("Teste1");
        observable.subscribe(s -> result = s);

        assertTrue(result.equals("Teste1"));

    }


    @Test
    public void observableFrom() {

        String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
        result = new String();

        Observable<String> observable = Observable.fromArray(letters);
        observable.subscribe(i -> result += i,
                Throwable::printStackTrace,
                () -> result += "_completed");

        assertTrue(result.equals("abcdefg_completed"));

    }


    @Test
    public void observableAsync() {

        String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
        result = new String();



        Observable.fromArray(letters)
                .subscribeOn(Schedulers.io())
                .doOnError(error -> erro(error))
                .doOnComplete(() -> completed(result))
                .subscribe(s -> exec(s),
                        error -> erro(error));

        assertTrue(result.equals("abcdefg_completed"));

    }

    public void completed(String s) {
        System.out.println("Completadooo " + s);
    }

    public void erro(Throwable msg) {
        System.out.println("ERROUUU " + msg.getMessage());
    }

    public void exec(String s) throws InterruptedException {
        System.out.println(s);
        if(s.equals("f"))
            throw new NumberFormatException("blaa");
        Thread.sleep(1000);
    }

    /**
     * Map -> aplica uma funcao alterando cada um dos opertators emitidos por um observable. (descartando o anterior)
     *
     */
    @Test
    public void observableFromTransformation() {

        String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
        result = new String();

        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe(letter -> result += letter);

        assertTrue(result.equals("ABCDEFG"));

    }

    /**
     * SCAN -> aplica uma funcao alterando cada um dos opertators emitidos por um observable.
     * 			Porem, diferente do MAP, mantem o estado anterior permitindo que se carregue o estado atual para os proximos eventos/
     */
    @Test
    public void observableFromScan() {

        String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
        result = new String();

        Observable.fromArray(letters)
                .scan(new StringBuilder(), StringBuilder::append)
                .subscribe(letter -> result += letter);


        assertTrue(result.equals("aababcabcdabcdeabcdefabcdefg"));

    }


    private String pares;
    private String impares;

    @Test
    public void observableFromGroupBy() {

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        result = new String();
        pares = new String();
        impares = new String();

        Observable.fromArray(numbers)
                .groupBy(key -> 0 == (key % 2) ? "PAR" : "IMPAR" )
                .subscribe(group ->
                        group.subscribe(number -> {
                            if(group.getKey().toString().equals("PAR"))
                                pares += number;
                            else
                                impares += number;
                        }));

        assertTrue(pares.equals("246"));
        assertTrue(impares.equals("1357"));



    }



}