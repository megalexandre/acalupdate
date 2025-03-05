package br.org.acal.application.screen.link;

import br.org.acal.domain.usecase.address.AddressFindUseCase;
import br.org.acal.domain.usecase.category.CategoryFindAllUseCase;
import br.org.acal.domain.usecase.customer.CustomerFindUseCase;
import br.org.acal.domain.usecase.link.LinkActiveUseCase;
import br.org.acal.domain.usecase.link.LinkCreateUseCase;
import br.org.acal.domain.usecase.link.LinkDeleteUseCase;
import br.org.acal.domain.usecase.link.LinkFindUseCase;
import jakarta.validation.Validator;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.JFrame;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinkViewTest{

    private FrameFixture window;
    private LinkFindUseCase find;
    private LinkCreateUseCase linkCreateUseCase;
    private LinkDeleteUseCase linkInactiveUseCase;
    private LinkActiveUseCase linkActiveUseCase;
    private AddressFindUseCase addressFindUsecase;
    private CategoryFindAllUseCase categoryFindAll;
    private CustomerFindUseCase customerFindUseCase;
    private Validator validator;

    private LinkView linkView;

    @BeforeEach
    void setup() {
        find = mock(LinkFindUseCase.class);
        linkCreateUseCase = mock(LinkCreateUseCase.class);
        linkInactiveUseCase = mock(LinkDeleteUseCase.class);
        linkActiveUseCase = mock(LinkActiveUseCase.class);
        addressFindUsecase = mock(AddressFindUseCase.class);
        categoryFindAll = mock(CategoryFindAllUseCase.class);
        customerFindUseCase = mock(CustomerFindUseCase.class);
        validator = mock(Validator.class);

        linkView = GuiActionRunner.execute(() -> new LinkView(
                find,
                linkCreateUseCase,
                linkInactiveUseCase,
                linkActiveUseCase,
                addressFindUsecase,
                categoryFindAll,
                customerFindUseCase,
                validator
        ));

        JFrame frame = GuiActionRunner.execute(() -> {
            JFrame f = new JFrame();
            f.setContentPane(linkView);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            return f;
        });

        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    void devePermitirPreencherCamposENaoQuebrar() {
    }

    @AfterEach
    void tearDown() {
        window.cleanUp();
    }
}