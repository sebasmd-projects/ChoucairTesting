#Autor: David Morales Valencia
#Email: davidmoralv@gmail.com
#language: es

@All
Característica: Validar la creacion, consulta, actualizacion y borrado de la API Dummy
Como un usuario
Yo quiero acceder al servicio Rest API Dummy
Para administrar la informacion de los empleados

Antecedentes: Acceso al servicio
Dado que se accede a la plataforma de endpoints

@Post
Esquema del escenario: Creacion de un empleado
Cuando el usuario crea un empleado
| <nombre> | <salario> | <edad> |
Entonces verifica la creacion de un nuevo registro en la base de datos
| <mensaje> |

Ejemplos:
| nombre  | salario | edad | mensaje                              |
| Sebastian   | 9000    | 45   | Successfully! Record has been added. |

@GetAll
Esquema del escenario: Consultar todos los empleados registrados
Cuando todos los empleados registrados son consultados
Entonces verifica la respuesta del servicio consultado
| <mensaje> |
Ejemplos:
| mensaje                                     |
| Successfully! All records has been fetched. |


@Get
Esquema del escenario: Consultar empleado
Cuando un empleado registrado es consultado
| <id> |
Entonces verifica la respuesta del servicio consultado
| <mensaje> |

Ejemplos:
| id | mensaje                                |
| 2  | Successfully! Record has been fetched. |


@Put
Esquema del escenario: Escenario: Modificar un registro de empleado
Cuando la informacion del empleado es modificada
| <id> | <nombre> | <salario> | <edad> |
Entonces verifica la respuesta del servicio consultado
| <mensaje> |
Ejemplos:
| id | nombre  | salario  | edad | mensaje                                |
| 23 | David   | 10000    | 46   | Successfully! Record has been updated. |


@Delete
Esquema del escenario: squemaEscenario: Borrar el registro de un empleado
Cuando un empleado registrado es eliminado
| <id> |
Entonces verifica la respuesta del servicio consultado
| <mensaje> |

Ejemplos:
| id | mensaje                               |
| 1  | Successfully! Record has been deleted |