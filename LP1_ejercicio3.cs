using System.Data.SqlClient;
using static Ejercicio3.Form1;

namespace Ejercicio3
{
    public partial class Form1 : Form
    {
        //GET/SET
        public class Notas
        {
            public int id { get; set; }
            public string nota { get; set; }
        }

        //LISTA
        List<Notas> notas = new List<Notas>();

        private string sConexion = "Server=DESKTOP-UABVL8N;database=RECUPERATORIO;Integrated Security=true";


        public Form1()
        {
            InitializeComponent();
            cargarGrid();
        }

        //CARGAR GRID CON LISTA
        public void cargarGrid()
        {
            notas.Clear();

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "SELECT * FROM Notas";

                SqlCommand comando = new SqlCommand(consulta, conexion);
                SqlDataReader reader = comando.ExecuteReader();


                while (reader.Read())
                {
                    notas.Add(new Notas
                    {
                        id = reader.GetInt32(0),
                        nota = reader[1].ToString()
                    });
                }
            }

            dataGridView1.DataSource = null;
            dataGridView1.DataSource = notas;

            limpiar();
        }


        //CARGAR
        public void cargar()
        {
            if (textBox1.Text == null)
            {
                MessageBox.Show("Debe ingresar una nota", "Error");
                return;
            }

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "INSERT INTO Notas (nota) VALUES (@nota)";
                SqlCommand comando = new SqlCommand(consulta, conexion);

                comando.Parameters.AddWithValue("@nota", textBox1.Text);
                comando.ExecuteNonQuery();
            }
            MessageBox.Show("Cargado", "Exito");
            cargarGrid();
        }

        //MODIFICAR
        public void editar()
        {
            if (textBox1.Text == null)
            {
                MessageBox.Show("Debe ingresar una nota", "Error");
                return;
            }

            int id = Convert.ToInt32(dataGridView1.CurrentRow.Cells["id"].Value);

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "UPDATE Notas SET nota = @nota WHERE id = @id";
                SqlCommand comando = new SqlCommand(consulta, conexion);

                comando.Parameters.AddWithValue("@nota", textBox1.Text);
                comando.Parameters.AddWithValue("@id", id);
                comando.ExecuteNonQuery();
            }
            MessageBox.Show("Editado", "Exito");
            cargarGrid();
        }

        //ELIMINAR 
        public void eliminar()
        {
            int id = Convert.ToInt32(dataGridView1.CurrentRow.Cells["id"].Value);

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "DELETE FROM Notas WHERE id = @id";
                SqlCommand comando = new SqlCommand(consulta, conexion);

                comando.Parameters.AddWithValue("@id", id);
                comando.ExecuteNonQuery();
            }
            MessageBox.Show("Eliminado", "Exito");
            cargarGrid();
        }

        //METODO LIMPIAR
        public void limpiar()
        {
            textBox1.Clear();
            textBox2.Clear();
        }

        //FILTRAR 
        public void filtrar()
        {

            int idNota = Convert.ToInt32(textBox2.Text);
            Notas nota1 = notas.FirstOrDefault(n => n.id == idNota);
            if (nota1 != null)
            {
                // Si se encuentra la nota, mostramos el valor en el TextBox correspondiente
                textBox1.Text = nota1.nota.ToString();
            }
            else
            {
                // Si no se encuentra, mostramos un mensaje de error
                MessageBox.Show("No se encontró una nota con ese ID", "Error");
                limpiar();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            cargar();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            editar();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            eliminar();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            filtrar();
        }

        //EVENTOS
        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView1.Rows.Count > 0)
            {
                textBox1.Text = dataGridView1.CurrentRow.Cells["nota"].Value?.ToString() ?? string.Empty;
                textBox2.Text = dataGridView1.CurrentRow.Cells["id"].Value?.ToString() ?? string.Empty;
            }
            else
            {
                textBox1.Clear();
                textBox2.Clear();
            }
        }
    }
}
