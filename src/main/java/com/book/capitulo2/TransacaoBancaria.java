import java.util.Objects;
import java.time.LocalDate;

public class TransacaoBancaria {
    private final LocalDate date;
    private final double valor;
    private final String description;

    public TransacaoBancaria(final LocalDate date, final double valor, final String description) {
        this.date = date;
        this.valor = valor;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValor() {
        return valor;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "TransacaoBancaria{" +
                "date=" + date +
                ", valor=" + valor +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoBancaria that = (TransacaoBancaria) o;
        return Double.compare(that.valor, valor) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);

    }

    @Override
    public int hashCode() {
        return Objects.hash(date, valor, description);
    }
}
