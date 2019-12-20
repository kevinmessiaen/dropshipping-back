package com.messiaen.dropshipping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.messiaen.dropshipping.enumeration.Civility;
import com.messiaen.dropshipping.enumeration.Country;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DeliveryInformationDto {

    @NotNull(message = "Le moyen de livraison est requis")
    private Short shippingMethod;
    @NotNull(message = "La civilité est requise")
    private Civility civility;
    @NotBlank(message = "Le prénom est requis")
    private String firstName;
    @NotBlank(message = "Le nom de famille est requis")
    private String lastName;
    @NotBlank(message = "La numéro et libellé de voie sont requis")
    private String street;
    private String complementary;
    private String building;
    private String locality;
    @NotBlank(message = "Le code postale est requis")
    @Pattern(regexp = "^(([0-8][0-9])|(9[0-5]))[0-9]{3}$",
            message = "Le format du code postale ne respecte pas le format XXYYY")
    private String postCode;
    @NotBlank(message = "La ville est requise")
    private String city;
    @NotNull(message = "Le pays est requis")
    private Country country;

}
