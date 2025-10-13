package co.edu.uniquindio.Pilas;

public class Nodo<T> {

        private T cima;
        private Nodo<T> proximo;

        public Nodo(T cima) {
            this.cima = cima;
            this.proximo = null;
        }

        public T getCima() {
            return cima;
        }

        public void setCima(T cima) {
            this.cima = cima;
        }

        public Nodo<T> getProximo() {
            return proximo;
        }

        public void setProximo(Nodo<T> proximo) {
            this.proximo = proximo;
        }
}
