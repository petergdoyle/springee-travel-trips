
#!/bin/bash

hsqldb_jar='~/NetBeansProjects/dev/lib/hsqldb-2.2.6/hsqldb.jar'
hsqldb_folder='~/apps/hsqldb/springeetravel/db'
hsqldb_port='9001'
hsqldb_name='springeetravel'

mkdir hsqldb_folder
java -cp $hsqldb_jar org.hsqldb.Server -database.0 $hsqldb_folder $hsqldb_port -dbname.0 $hsqldb_name