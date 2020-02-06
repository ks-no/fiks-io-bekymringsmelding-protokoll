package no.ks.fiks.bekymringsmelding.schema

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import no.ks.fiks.bekymringsmelding.schema.domain.Feilmelding
import no.ks.fiks.bekymringsmelding.schema.domain.OffentligBekymringsmeldingV1
import no.ks.fiks.bekymringsmelding.schema.domain.PrivatBekymringsmeldingV1
import org.apache.commons.io.IOUtils


class JsonSchemaTest : StringSpec() {

    init {
        "Test at eksempel på JSON-fil validerer med generert POJO for privat bekymringsmelding" {
            val resource = IOUtils.toString(Thread.currentThread().contextClassLoader.getResourceAsStream("bekymringsmelding-json-schema/examples/privatBekymringsmelding.json"), "UTF-8")
            val privatBekymringsmelding = ObjectMapper().readValue(resource, PrivatBekymringsmeldingV1::class.java)

            privatBekymringsmelding.kommunenummer shouldBe "1201"
            privatBekymringsmelding.kommunenavn shouldBe "Bergen"
            privatBekymringsmelding.bydelsnummer shouldBe "02"
            privatBekymringsmelding.bydelsnavn shouldBe "Bergenhus"

            // Melder
            privatBekymringsmelding.privatMelder.fnr shouldBe "22078347825"
            privatBekymringsmelding.privatMelder.personnavn shouldBe "Navnesen Navn Mellomnavn"
            privatBekymringsmelding.privatMelder.telefonnummer shouldBe "99999999"
            privatBekymringsmelding.privatMelder.skjultIdentitet shouldBe true
            privatBekymringsmelding.privatMelder.adresse.adresselinje1 shouldBe "Rosenkrantzgaten 3"
            privatBekymringsmelding.privatMelder.adresse.adresselinje2 shouldBe ""
            privatBekymringsmelding.privatMelder.adresse.adresselinje3 shouldBe ""
            privatBekymringsmelding.privatMelder.adresse.postnummer shouldBe "5003"
            privatBekymringsmelding.privatMelder.adresse.poststed shouldBe "Bergen"

            // Barn
            privatBekymringsmelding.privatBarn[0].personnavn shouldBe "Barn Barnesen"
            privatBekymringsmelding.privatBarn[0].antattAlder shouldBe "10"
            privatBekymringsmelding.privatBarn[0].relasjon shouldBe "Nabo, fritekstfelt"
            privatBekymringsmelding.privatBarn[0].adresse.adresselinje1 shouldBe "Rådhusgaten 10"
            privatBekymringsmelding.privatBarn[0].adresse.adresselinje2 shouldBe ""
            privatBekymringsmelding.privatBarn[0].adresse.adresselinje3 shouldBe ""
            privatBekymringsmelding.privatBarn[0].adresse.postnummer shouldBe "5020"
            privatBekymringsmelding.privatBarn[0].adresse.poststed shouldBe "Bergen"
            privatBekymringsmelding.privatBarn[1].personnavn shouldBe "Bare Barnet"
            privatBekymringsmelding.privatBarn[1].antattAlder shouldBe "10"
            privatBekymringsmelding.privatBarn[1].relasjon shouldBe "Nabo, fritekstfelt"
            privatBekymringsmelding.privatBarn[1].adresse.adresselinje1 shouldBe "Rådhusgaten 10"
            privatBekymringsmelding.privatBarn[1].adresse.adresselinje2 shouldBe ""
            privatBekymringsmelding.privatBarn[1].adresse.adresselinje3 shouldBe ""
            privatBekymringsmelding.privatBarn[1].adresse.postnummer shouldBe "5020"
            privatBekymringsmelding.privatBarn[1].adresse.poststed shouldBe "Bergen"

            privatBekymringsmelding.melding shouldBe "Her kommer selve innholdet i bekymringsmeldingen!"
        }

        "Test at eksempel på JSON-fil validerer med generert POJO for offentlig bekymringsmelding" {
            val resource = IOUtils.toString(Thread.currentThread().contextClassLoader.getResourceAsStream("bekymringsmelding-json-schema/examples/offentligBekymringsmelding.json"), "UTF-8")
            val offentligBekymringsmelding = ObjectMapper().readValue(resource, OffentligBekymringsmeldingV1::class.java)

            offentligBekymringsmelding.kommunenummer shouldBe "1201"
            offentligBekymringsmelding.kommunenavn shouldBe "Bergen"
            offentligBekymringsmelding.bydelsnummer shouldBe "02"
            offentligBekymringsmelding.bydelsnavn shouldBe "Bergenhus"

            // Melder
            offentligBekymringsmelding.offentligMelder.personnavn shouldBe "Navnesen Navn Mellomnavn"
            offentligBekymringsmelding.offentligMelder.rolle shouldBe "Lærer"
            offentligBekymringsmelding.offentligMelder.telefonnummer shouldBe "99999999"
            offentligBekymringsmelding.offentligMelder.epost shouldBe "lærer@skole.no"
            offentligBekymringsmelding.offentligMelder.virksomhet.navn shouldBe "Lærerskolen"
            offentligBekymringsmelding.offentligMelder.virksomhet.orgnr shouldBe "123455789"
            offentligBekymringsmelding.offentligMelder.virksomhet.adresse.adresselinje1 shouldBe "Rosenkrantzgaten 3"
            offentligBekymringsmelding.offentligMelder.virksomhet.adresse.adresselinje2 shouldBe ""
            offentligBekymringsmelding.offentligMelder.virksomhet.adresse.adresselinje3 shouldBe ""
            offentligBekymringsmelding.offentligMelder.virksomhet.adresse.postnummer shouldBe "5003"
            offentligBekymringsmelding.offentligMelder.virksomhet.adresse.poststed shouldBe "Bergen"

            // Barn
            offentligBekymringsmelding.offentligBarn[0].fnr shouldBe "28071364498"
            offentligBekymringsmelding.offentligBarn[0].ufoedt shouldBe false
            offentligBekymringsmelding.offentligBarn[0].personnavn shouldBe "Barn Barnesen"
            offentligBekymringsmelding.offentligBarn[0].telefonnummer shouldBe "12121212"
            offentligBekymringsmelding.offentligBarn[0].adresse.adresselinje1 shouldBe "Rådhusgaten 10"
            offentligBekymringsmelding.offentligBarn[0].adresse.adresselinje2 shouldBe ""
            offentligBekymringsmelding.offentligBarn[0].adresse.adresselinje3 shouldBe ""
            offentligBekymringsmelding.offentligBarn[0].adresse.postnummer shouldBe "5020"
            offentligBekymringsmelding.offentligBarn[0].adresse.poststed shouldBe "Bergen"
            offentligBekymringsmelding.offentligBarn[0].orientert shouldBe false
            offentligBekymringsmelding.offentligBarn[0].orientertGrunn shouldBe "Synes det er vanskelig å snakke om dette."
            offentligBekymringsmelding.offentligBarn[1].fnr shouldBe "16081688781"
            offentligBekymringsmelding.offentligBarn[1].ufoedt shouldBe false
            offentligBekymringsmelding.offentligBarn[1].personnavn shouldBe "Bare Barnet"
            offentligBekymringsmelding.offentligBarn[1].telefonnummer shouldBe "13131313"
            offentligBekymringsmelding.offentligBarn[1].adresse.adresselinje1 shouldBe "Rådhusgaten 10"
            offentligBekymringsmelding.offentligBarn[1].adresse.adresselinje2 shouldBe ""
            offentligBekymringsmelding.offentligBarn[1].adresse.adresselinje3 shouldBe ""
            offentligBekymringsmelding.offentligBarn[1].adresse.postnummer shouldBe "5020"
            offentligBekymringsmelding.offentligBarn[1].adresse.poststed shouldBe "Bergen"
            offentligBekymringsmelding.offentligBarn[1].orientert shouldBe false
            offentligBekymringsmelding.offentligBarn[1].orientertGrunn shouldBe "Synes det er vanskelig å snakke om dette."

            // Foresatte
            offentligBekymringsmelding.foresatte[0].personnavn shouldBe "Foresatt Foresatt"
            offentligBekymringsmelding.foresatte[0].telefonnummer shouldBe "45444342"
            offentligBekymringsmelding.foresatte[0].orientert shouldBe true
            offentligBekymringsmelding.foresatte[0].personnavn shouldBe "Foresatt Foresatt"

            offentligBekymringsmelding.behovForTolk shouldBe "Nei, de snakker norsk."
            offentligBekymringsmelding.andreHjelpeinstanser shouldBe "Nei, ikke vært i kontakt med andre hjelpeinstanser."
            offentligBekymringsmelding.melding.melding shouldBe "Her kommer selve innholdet i bekymringsmeldingen!"
            offentligBekymringsmelding.melding.historie shouldBe "Her kommer selve historien i bekymringsmeldingen!"
        }

        "Test at man kan sette feilmelding" {
            val resource = IOUtils.toString(Thread.currentThread().contextClassLoader.getResourceAsStream("bekymringsmelding-json-schema/examples/feilmelding.json"), "UTF-8")
            val feilmelding = ObjectMapper().readValue(resource, Feilmelding::class.java)

            feilmelding.melding shouldBe "Kunne ikke parse JSON-filen bekymringsmelding.json"
        }

        "Test at man ikke trenger å skrive noe i feilmeldingen" {
            val resource = IOUtils.toString(Thread.currentThread().contextClassLoader.getResourceAsStream("bekymringsmelding-json-schema/examples/feilmelding_tom.json"), "UTF-8")
            val feilmelding = ObjectMapper().readValue(resource, Feilmelding::class.java)

            feilmelding.melding shouldBe null
        }
    }
}