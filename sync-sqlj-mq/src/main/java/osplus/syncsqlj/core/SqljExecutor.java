package osplus.syncsqlj.core;

/**
 * Ausführungshilfe für SQLJ-Objekte.
 */
public interface SqljExecutor {
    /**
     * Führt ein SQLJ-Objekt innerhalb einer Transaktion aus.
     * @param object zu ausführendes Objekt
     * @return Ergebnis
     */
    <T> T run(SqljObject<T> object);
}
