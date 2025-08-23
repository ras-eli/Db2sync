package de.syncdb2.core;

/**
 * Führt {@link SqljObject} innerhalb einer Transaktion aus.
 */
public interface SqljExecutor {

    /**
     * Führt das übergebene Objekt aus.
     * @param sqljObject Logik
     * @param <T> Ergebnistyp
     * @return Ergebnis des Aufrufs
     */
    <T> T execute(SqljObject<T> sqljObject);
}
