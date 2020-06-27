package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private final Integer VAGAS = 10;
    private final Integer LIMITE_IDADE = 55;
    private final List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {
      if (carrosEstacionados() < VAGAS) {
          carros.add(carro);
      } else if (carrosEstacionados() == VAGAS && removerCarro()) {
          carros.add(carro);
      } else {
        throw new EstacionamentoException("Não há mais vagas disponíveis!");
      }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }

    private Boolean removerCarro() {
        for (Carro carro : carros) {
            if (carro.getMotorista().getIdade() <= LIMITE_IDADE) {
                carros.remove(carro);
                return true;
            }
        }
        return false;
    }
}
