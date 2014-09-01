package broovyws

@Grab(group='com.github.groovy-wslite', module='groovy-wslite', version='0.8.0')
import wslite.soap.*

def client = new SOAPClient('http://www.webservicex.net/CurrencyConvertor.asmx')
def response = client.send(SOAPAction: 'http://www.webserviceX.NET/ConversionRate') {
    body {
        ConversionRate( xmlns: 'http://www.webserviceX.NET/') {
            FromCurrency('CAD')
            ToCurrency('USD')
        }
    }
}

assert response
assert 200 == response.httpResponse.statusCode

println response.ConversionRateResponse.ConversionRateResult.text()
