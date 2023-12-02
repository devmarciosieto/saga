package br.com.mmmsieto.paymentservice.application.core.usecase;

import br.com.mmmsieto.paymentservice.application.core.domain.Payment;
import br.com.mmmsieto.paymentservice.application.core.domain.Sale;
import br.com.mmmsieto.paymentservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.paymentservice.application.ports.in.FindUserByIdInputPort;
import br.com.mmmsieto.paymentservice.application.ports.in.SalePaymentInputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.SavePaymentOutputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.SendValidadedPaymentOutputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendValidadedPaymentOutputPort sendValidadedPaymentOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort,
                              UpdateUserOutputPort updateUserOutputPort,
                              SavePaymentOutputPort savePaymentOutputPort,
                              SendValidadedPaymentOutputPort sendValidadedPaymentOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidadedPaymentOutputPort = sendValidadedPaymentOutputPort;
    }

    @Override
    public void payment(Sale sale) {

        var user = findUserByIdInputPort.find(sale.getUserId());

        if (user.getBalance().compareTo(sale.getValue()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        user.debitBalance(sale.getValue());
        updateUserOutputPort.update(user);
        savePaymentOutputPort.save(createPayment(sale));
        sendValidadedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);

    }

    private Payment createPayment(Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }

}
