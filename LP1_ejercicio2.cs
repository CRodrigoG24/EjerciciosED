using Microsoft.VisualBasic;
using System.Data;
using System.Data.SqlClient;


namespace Ejercicio2
{
    public partial class FormTelefonos : Form
    {

        //CLASE PARA REPRESENTAR LOS DATOS DE LA CLASE
        public class Tema1
        {
            public int id { get; set; }
            public string apellido { get; set; }
            public string numero { get; set; }
        }

        //LISTA PARA CARGAR DESDE BD
        List<Tema1> tema1 = new List<Tema1>();

        //STRING CONEXION CON LA BD
        private string sConexion = "Server=DESKTOP-UABVL8N;database=RECUPERATORIO;Integrated Security=true";


        public FormTelefonos()
        {
            InitializeComponent();
            CargarGrid();
        }

        //---------------------------------------------------------METODOS---------------------------------------------------------
        //CARGA ELEMENTOS DE LA BD EN EL GRID
        public void CargarGrid()
        {
            tema1.Clear();
            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "SELECT * FROM Telefonos";
                SqlCommand comando = new SqlCommand(consulta, conexion);
                SqlDataReader reader = comando.ExecuteReader();

                while (reader.Read())
                {
                    tema1.Add(new Tema1
                    {
                        id = reader.GetInt32(0),
                        apellido = reader.GetString(1),
                        numero = reader.GetString(2),
                    });
                }

            }
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = tema1;
            limpiar();
        }

        //METODO CARGAR
        public void cargar()
        {
            if (textBox1.Text == null || textBox2.Text == null)
            {
                MessageBox.Show("Falta completar campos", "Error");
                return;
            }

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "INSERT INTO Telefonos (apellido, numero) VALUES (@apellido, @numero)";
                SqlCommand comando = new SqlCommand(consulta, conexion);

                comando.Parameters.AddWithValue("@apellido", textBox1.Text);
                comando.Parameters.AddWithValue("@numero", textBox2.Text);

                comando.ExecuteNonQuery();
            }

            MessageBox.Show("Telefono cargado exitosamente!", "Exito");
            CargarGrid();
        }

        //METODO MODIFICAR
        public void modificar()
        {
            if (dataGridView1.CurrentRow == null) return;

            if (string.IsNullOrWhiteSpace(textBox1.Text) || string.IsNullOrWhiteSpace(textBox2.Text))
            {
                MessageBox.Show("Falta completar campos", "Error");
                return;
            }

            int id = Convert.ToInt32(dataGridView1.CurrentRow.Cells["id"].Value);

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "UPDATE Telefonos SET apellido = @apellido, numero = @numero WHERE id = @id";
                SqlCommand comando = new SqlCommand(consulta, conexion);

                comando.Parameters.AddWithValue("@apellido", textBox1.Text);
                comando.Parameters.AddWithValue("@numero", textBox2.Text);
                comando.Parameters.AddWithValue("@id", id);

                comando.ExecuteNonQuery();
            }

            MessageBox.Show("Telefono modificado exitosamente", "Exito");
            CargarGrid();
        }

        //METODO ELIMINAR 
        public void eliminar()
        {

            int id = Convert.ToInt32(dataGridView1.CurrentRow.Cells["id"].Value);

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "DELETE FROM Telefonos WHERE id = @id";
                SqlCommand comando = new SqlCommand(consulta, conexion);

                comando.Parameters.AddWithValue("@id", id);
                comando.ExecuteNonQuery();
            }

            MessageBox.Show("Teléfono eliminado exitosamente", "Éxito");
            CargarGrid();
        }

        //METODO FILTRAR
        public void filtrar()
        {
            string apellido = textBox1.Text;

            Tema1 telefono = tema1.FirstOrDefault(t => t.apellido.Equals(apellido, StringComparison.OrdinalIgnoreCase));
            if (telefono != null)
            {
                textBox2.Text = telefono.numero;
            }
            else
            {
                MessageBox.Show("No se encontró un teléfono con ese apellido", "Error");
                limpiar();
            }
        }

        //METODO LIMPIAR
        public void limpiar()
        {
            textBox1.Clear();
            textBox2.Clear();
        }


        //---------------------------------------------------------BOTONES---------------------------------------------------------
        private void button1_Click(object sender, EventArgs e)
        {
            cargar();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            modificar();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            eliminar();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            limpiar();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            filtrar();
        }

        //---------------------------------------------------------EVENTOS---------------------------------------------------------
        private void textBox1_Click(object sender, EventArgs e)
        {
            
        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView1.Rows.Count > 0)
            {
                textBox1.Text = dataGridView1.CurrentRow.Cells["apellido"].Value?.ToString() ?? string.Empty;
                textBox2.Text = dataGridView1.CurrentRow.Cells["numero"].Value?.ToString() ?? string.Empty;
            }
            else
            {
                textBox1.Clear();
                textBox2.Clear();
            }
        }
    }
}
