using System;
using System.IO;
using System.Text;

namespace ConsTest
{
    class Program
    {
        static void Main(string[] args)
        {
            if(args.Length < 1)
            {
                Console.Error.WriteLine("Filename is required.");
                Environment.Exit(1);
            }
            try
            {
                var filename = args[0];
                var arabicWindowsEncoding = Encoding.GetEncoding(1256);
                var text = File.ReadAllText(filename, arabicWindowsEncoding);
                using (var streamWriter = new StreamWriter(new FileStream(filename, FileMode.Open, FileAccess.Write), Encoding.UTF8))
                {
                    streamWriter.Write(text);
                    streamWriter.Flush();
                }
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine(ex);
                Environment.Exit(2);
            }
            
        }
    }
}
