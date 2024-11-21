using System.Data.SqlClient;

namespace ejercicio1
{
    public partial class Form1 : Form
    {
        public class Producto
        {
            public int id { get; set; }
            public string nombre { get; set; }
        }

        List<Producto> productos = new List<Producto>();

        private string sConexion = "Server=DESKTOP-UABVL8N;database=RECUPERATORIO;Integrated Security=true";


        public Form1()
        {
            InitializeComponent();
            cargarGrid();
        }


        public void cargarGrid()
        {
            productos.Clear();

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "SELECT * FROM Productos";
                SqlCommand comando = new SqlCommand(consulta, conexion);
                SqlDataReader reader = comando.ExecuteReader();

                while (reader.Read())
                {
                    productos.Add(new Producto
                    {
                        id = reader.GetInt32(0),
                        nombre = reader[1].ToString()
                    });
                }
            }

            dataGridView1.DataSource = null;
            dataGridView1.DataSource = productos;

            limpiar();
        }


        public void limpiar()
        {
            textBox1.Clear();
        }

        //CARGAR
        public void cargar()
        {
            if (string.IsNullOrWhiteSpace(textBox1.Text))
            {
                MessageBox.Show("Debe ingresar un nombre de producto.", "Error");
                return;
            }

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "INSERT INTO Productos (nombre) VALUES (@nombre)";
                SqlCommand comando = new SqlCommand(consulta, conexion);
                comando.Parameters.AddWithValue("@nombre", textBox1.Text);
                comando.ExecuteNonQuery();
            }

            MessageBox.Show("Producto cargado con éxito.", "Éxito");
            cargarGrid();
        }


        //MODIFICAR
        public void modificar()
        {
            if (dataGridView1.CurrentRow == null)
            {
                MessageBox.Show("Debe seleccionar un producto para modificar.", "Error");
                return;
            }

            int id = Convert.ToInt32(dataGridView1.CurrentRow.Cells["id"].Value);

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "UPDATE Productos SET nombre = @nombre WHERE id = @id";
                SqlCommand comando = new SqlCommand(consulta, conexion);
                comando.Parameters.AddWithValue("@nombre", textBox1.Text);
                comando.Parameters.AddWithValue("@id", id);
                comando.ExecuteNonQuery();
            }

            MessageBox.Show("Producto modificado con éxito.", "Éxito");
            cargarGrid();
        }

        //ELIMINAR
        public void eliminar()
        {
            if (dataGridView1.CurrentRow == null)
            {
                MessageBox.Show("Debe seleccionar un producto para eliminar.", "Error");
                return;
            }

            int id = Convert.ToInt32(dataGridView1.CurrentRow.Cells["id"].Value);

            using (SqlConnection conexion = new SqlConnection(sConexion))
            {
                conexion.Open();
                string consulta = "DELETE FROM Productos WHERE id = @id";
                SqlCommand comando = new SqlCommand(consulta, conexion);
                comando.Parameters.AddWithValue("@id", id);
                comando.ExecuteNonQuery();
            }

            MessageBox.Show("Producto eliminado con éxito.", "Éxito");
            cargarGrid();
        }


        //FILTRAR
        public void filtrar()
        {
            string nombreFiltro = textBox1.Text.Trim();
            var productosFiltrados = productos.Where(p => p.nombre.Contains(nombreFiltro)).ToList();

            if (productosFiltrados.Count > 0)
            {
                dataGridView1.DataSource = null;
                dataGridView1.DataSource = productosFiltrados;
            }
            else
            {
                MessageBox.Show("No se encontraron productos con ese nombre.", "Error");
                cargarGrid();
            }
        }

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
            filtrar();
        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView1.Rows.Count > 0 && dataGridView1.CurrentRow != null)
            {
                textBox1.Text = dataGridView1.CurrentRow.Cells["nombre"].Value?.ToString() ?? string.Empty;
            }
            else
            {
                textBox1.Clear();
            }
        }
    }
}
