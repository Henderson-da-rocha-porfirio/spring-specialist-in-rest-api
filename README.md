# EXCECOES_Com_Try_Catch
````
* try {
          return cityRegisterService.salvar(city);
        } catch (EntidadeNaoEncontradaException e) {
            throw new BusinessException(e.getMessage());
        }
````
### - Quando tenta salvar uma cidade que não existe, ele captura EntidadeNaoEncontradaException e relança como BusinessException. */